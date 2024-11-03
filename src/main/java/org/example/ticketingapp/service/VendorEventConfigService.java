package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.VendorEventConfigDTO;

import java.util.List;

public interface VendorEventConfigService {
    VendorEventConfigDTO createVendorEventConfig(VendorEventConfigDTO vendorEventConfigDTO);
    VendorEventConfigDTO getVendorEventConfigByEventName(String eventName);
    List<VendorEventConfigDTO> getAllVendorEventConfigsByEmail(String email);
    VendorEventConfigDTO updateTotalTickets(String eventName, int totalTickets);
    boolean existsByEventName(String eventName);
}
