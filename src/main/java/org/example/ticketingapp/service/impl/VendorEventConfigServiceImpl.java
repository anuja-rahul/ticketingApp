package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.entity.VendorEventConfig;
import org.example.ticketingapp.mapper.VendorEventConfigMapper;
import org.example.ticketingapp.repository.VendorEventConfigRepository;
import org.example.ticketingapp.service.VendorEventConfigService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VendorEventConfigServiceImpl implements VendorEventConfigService {

    private VendorEventConfigRepository vendorEventConfigRepository;

    @Override
    public VendorEventConfigDTO createVendorConfig(VendorEventConfigDTO vendorEventConfigDTO) {

        VendorEventConfig vendorEventConfig = VendorEventConfigMapper.mapToVendorEventConfig(vendorEventConfigDTO);
        VendorEventConfig savedVendorEventConfig = vendorEventConfigRepository.save(vendorEventConfig);
        return VendorEventConfigMapper.mapToVendorEventConfigDto(savedVendorEventConfig);
    }

    @Override
    public VendorEventConfigDTO getVendorEventConfigByEmail(String email) {
        return null;
    }

    @Override
    public VendorEventConfigDTO getAllVendorEventConfigs(String email) {
        return null;
    }
}
