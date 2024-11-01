package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.entity.VendorEventConfig;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.VendorEventConfigMapper;
import org.example.ticketingapp.repository.VendorEventConfigRepository;
import org.example.ticketingapp.service.VendorEventConfigService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class VendorEventConfigServiceImpl implements VendorEventConfigService {

    private final VendorEventConfigRepository vendorEventConfigRepository;

    @Override
    public VendorEventConfigDTO createVendorEventConfig(VendorEventConfigDTO vendorEventConfigDTO) {
        VendorEventConfig vendorEventConfig = VendorEventConfigMapper.mapToVendorEventConfig(vendorEventConfigDTO);
        VendorEventConfig savedVendorEventConfig = vendorEventConfigRepository.save(vendorEventConfig);
        return VendorEventConfigMapper.mapToVendorEventConfigDto(savedVendorEventConfig);
    }


//    @Override
//    public VendorEventConfigDTO getVendorEventConfigByEmail(String email) {
//        VendorEventConfig vendorEventConfig = vendorEventConfigRepository.findByEmail(email)
//                .orElseThrow(() -> new ResourceNotFoundException("VendorEventConfig not found: " + email));
//        return VendorEventConfigMapper.mapToVendorEventConfigDto(vendorEventConfig);
//    }

    // TODO: FIX THIS
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
    public boolean existsByEventName(String eventName) {
        return vendorEventConfigRepository.existsByEventName(eventName);
    }


}
