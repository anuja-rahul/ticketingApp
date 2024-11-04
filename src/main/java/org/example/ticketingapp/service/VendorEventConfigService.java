package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.dto.VendorEventConfigDTOIn;

import java.io.IOException;
import java.util.List;

public interface VendorEventConfigService {
    VendorEventConfigDTO createVendorEventConfig(VendorEventConfigDTOIn vendorEventConfigDTOIn, String email) throws IOException;
    VendorEventConfigDTO getVendorEventConfigByEventName(String eventName);
    List<VendorEventConfigDTO> getAllVendorEventConfigsByEmail(String email);
    VendorEventConfigDTO updateTotalTickets(String eventName, int totalTickets) throws IOException;
    boolean existsByEventName(String eventName);
    void buyTickets(String eventName);
}
