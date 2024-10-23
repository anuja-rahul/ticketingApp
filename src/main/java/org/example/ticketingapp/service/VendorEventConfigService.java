package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.VendorEventConfigDTO;

public interface VendorEventConfigService {
    VendorEventConfigDTO createVendorConfig(VendorEventConfigDTO vendorEventConfigDTO);
    VendorEventConfigDTO getVendorEventConfigByEmail(String email);
    VendorEventConfigDTO getAllVendorEventConfigs(String email);
}
