package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.VendorEventConfigDTO;

import java.util.List;

public interface VendorEventConfigService {
    VendorEventConfigDTO createVendorConfig(VendorEventConfigDTO vendorEventConfigDTO);
    VendorEventConfigDTO getVendorEventConfigByEventName(String eventName);
    List<VendorEventConfigDTO> getAllVendorEventConfigsByEmail(String email);
}
