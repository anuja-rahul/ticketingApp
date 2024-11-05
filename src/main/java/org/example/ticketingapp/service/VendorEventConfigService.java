package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.dto.VendorEventConfigDTOIn;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface VendorEventConfigService {
    CompletableFuture<VendorEventConfigDTO> createVendorEventConfig(VendorEventConfigDTOIn vendorEventConfigDTOIn, String email) throws IOException;
    CompletableFuture<VendorEventConfigDTO> getVendorEventConfigByEventName(String eventName);
    CompletableFuture<List<VendorEventConfigDTO>> getAllVendorEventConfigsByEmail(String email);
    VendorEventConfigDTO updateTotalTickets(String eventName, int totalTickets) throws IOException;
    boolean existsByEventName(String eventName);
    void buyTickets(String eventName);
}
