package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.cli.CliVendorEventConfig;
import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.dto.VendorEventConfigDTOIn;
import org.example.ticketingapp.entity.VendorEventConfig;
import org.example.ticketingapp.exception.ResourceCapacityException;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.VendorEventConfigMapper;
import org.example.ticketingapp.repository.VendorEventConfigRepository;
import org.example.ticketingapp.service.VendorEventConfigService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class VendorEventConfigServiceImpl implements VendorEventConfigService {

    private final VendorEventConfigRepository vendorEventConfigRepository;

    @Override
    public VendorEventConfigDTO createVendorEventConfig(
            VendorEventConfigDTOIn vendorEventConfigDTOin,
            String email) throws IOException {

        CliVendorEventConfig cliVendorEventConfig = CliVendorEventConfig.readFromJson();
        VendorEventConfigDTO vendorEventConfigDTO = VendorEventConfigMapper.mapFromInputSchema(
                cliVendorEventConfig,
                vendorEventConfigDTOin,
                email);
        VendorEventConfig vendorEventConfig = VendorEventConfigMapper.mapToVendorEventConfig(vendorEventConfigDTO);
        VendorEventConfig savedVendorEventConfig = vendorEventConfigRepository.save(vendorEventConfig);
        return VendorEventConfigMapper.mapToVendorEventConfigDto(savedVendorEventConfig);
    }


    @Override
    public VendorEventConfigDTO getVendorEventConfigByEventName(String eventName) {
        VendorEventConfig vendorEventConfig = vendorEventConfigRepository.findByEventName(eventName)
                .orElseThrow(() -> new ResourceNotFoundException("VendorEventConfig not found: " + eventName));
        return VendorEventConfigMapper.mapToVendorEventConfigDto(vendorEventConfig);
    }

    @Override
    public List<VendorEventConfigDTO> getAllVendorEventConfigsByEmail(String email) {
        List<VendorEventConfig> vendorEventConfigs = vendorEventConfigRepository.findAllByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("VendorEventConfig not found: " + email));
        return vendorEventConfigs.stream()
                .map(VendorEventConfigMapper::mapToVendorEventConfigDto)
                .collect(Collectors.toList());
    }

    @Override
    public VendorEventConfigDTO updateTotalTickets(String eventName, int totalTickets){

        VendorEventConfig vendorEventConfig = vendorEventConfigRepository.findByEventName(eventName)
                .orElseThrow(() -> new ResourceNotFoundException("VendorEventConfig not found by event name " + eventName));

        if (vendorEventConfig.getMaxTicketCapacity() > totalTickets) {
            vendorEventConfig.setTotalTickets(totalTickets);
            VendorEventConfig updatedVendorEventConfig = vendorEventConfigRepository.save(vendorEventConfig);

            return VendorEventConfigMapper.mapToVendorEventConfigDto(updatedVendorEventConfig);
        }
        throw(new ResourceCapacityException("Total capacity exceeded"));
    }

    @Override
    public boolean existsByEventName(String eventName) {
        return vendorEventConfigRepository.existsByEventName(eventName);
    }

    @Override
    public void buyTickets(String eventName) {
        VendorEventConfig vendorEventConfig = vendorEventConfigRepository.findByEventName(eventName)
                .orElseThrow(() -> new ResourceNotFoundException("VendorEventConfig not found by event name " + eventName));

        if (vendorEventConfig.getTotalTickets() > vendorEventConfig.getCustomerRetrievalRate()) {
            vendorEventConfig.setTotalTickets(vendorEventConfig.getTotalTickets() - vendorEventConfig.getCustomerRetrievalRate());
            vendorEventConfigRepository.save(vendorEventConfig);
        }else {
            throw new ResourceCapacityException("Not enough tickets available");
        }
    }

}
