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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class VendorEventConfigServiceImpl implements VendorEventConfigService {

    private final VendorEventConfigRepository vendorEventConfigRepository;
    private final Lock lock = new ReentrantLock();

    @Override
    @Async("vendorExecutor")
    public CompletableFuture<VendorEventConfigDTO> createVendorEventConfig(
            VendorEventConfigDTOIn vendorEventConfigDTOin,
            String email) throws IOException {

        CliVendorEventConfig cliVendorEventConfig = CliVendorEventConfig.readFromJson();
        VendorEventConfigDTO vendorEventConfigDTO = VendorEventConfigMapper.mapFromInputSchema(
                cliVendorEventConfig,
                vendorEventConfigDTOin,
                email);
        VendorEventConfig vendorEventConfig = VendorEventConfigMapper.mapToVendorEventConfig(vendorEventConfigDTO);
        VendorEventConfig savedVendorEventConfig = vendorEventConfigRepository.save(vendorEventConfig);
        VendorEventConfigDTO result = VendorEventConfigMapper.mapToVendorEventConfigDto(savedVendorEventConfig);
        return CompletableFuture.completedFuture(result);
    }

    @Override
    @Transactional
    public void deleteVendorEventConfig(String eventName, String email) {

        VendorEventConfig vendorEventConfig = vendorEventConfigRepository.findByEventName(eventName)
                .orElseThrow(() -> new ResourceNotFoundException("VendorEventConfig not found by event name " + eventName));
        if (vendorEventConfig.getEmail().equals(email)) {
            vendorEventConfigRepository.deleteByEventName(eventName);
        } else {
            throw new ResourceNotFoundException("VendorEventConfig not owned by vendor " + email);
        }
    }


    @Override
    @Async("vendorExecutor")
    public CompletableFuture<VendorEventConfigDTO> getVendorEventConfigByEventName(String eventName) {
        VendorEventConfig vendorEventConfig = vendorEventConfigRepository.findByEventName(eventName)
                .orElseThrow(() -> new ResourceNotFoundException("VendorEventConfig not found: " + eventName));
        VendorEventConfigDTO result = VendorEventConfigMapper.mapToVendorEventConfigDto(vendorEventConfig);
        return CompletableFuture.completedFuture(result);
    }

    @Override
    @Async("vendorExecutor")
    public CompletableFuture<List<VendorEventConfigDTO>> getAllVendorEventConfigsByEmail(String email) {
        List<VendorEventConfig> vendorEventConfigs = vendorEventConfigRepository.findAllByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("VendorEventConfig not found: " + email));
        List<VendorEventConfigDTO> result = vendorEventConfigs.stream()
                .map(VendorEventConfigMapper::mapToVendorEventConfigDto)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(result);
    }

    // synchronized method to update total tickets
    @Override
    @Async("vendorExecutor")
    @Transactional
    public CompletableFuture<VendorEventConfigDTO> updateTotalTickets(String eventName, int totalTickets){
        lock.lock();
        try {
            VendorEventConfig vendorEventConfig = vendorEventConfigRepository.findByEventName(eventName)
                    .orElseThrow(() -> new ResourceNotFoundException("VendorEventConfig not found by event name " + eventName));

            if (vendorEventConfig.getMaxTicketCapacity() > totalTickets) {
                vendorEventConfig.setTotalTickets(totalTickets);
                VendorEventConfig updatedVendorEventConfig = vendorEventConfigRepository.save(vendorEventConfig);

                VendorEventConfigDTO result = VendorEventConfigMapper.mapToVendorEventConfigDto(updatedVendorEventConfig);

                return CompletableFuture.completedFuture(result);
            }
            throw(new ResourceCapacityException("Total capacity exceeded"));

        } finally {
            lock.unlock();
        }

    }

    @Override
    public boolean existsByEventName(String eventName) {
        return vendorEventConfigRepository.existsByEventName(eventName);
    }

    @Override
    @Async("ticketExecutor")
    @Transactional
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

    @Override
    @Async("taskExecutor")
    public CompletableFuture<List<VendorEventConfigDTO>> getAllVendorEventConfigs() {
        List<VendorEventConfig> vendorEventConfigList = vendorEventConfigRepository.findAll();
        List<VendorEventConfigDTO> vendorEventConfigDTOList = vendorEventConfigList.stream()
                .map(VendorEventConfigMapper::mapToVendorEventConfigDto)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(vendorEventConfigDTOList);
    }

}
