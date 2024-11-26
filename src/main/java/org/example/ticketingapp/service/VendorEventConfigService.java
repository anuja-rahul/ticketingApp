package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;
import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.dto.VendorEventConfigDTOIn;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface VendorEventConfigService {
    CompletableFuture<VendorEventConfigDTO> createVendorEventConfig(VendorEventConfigDTOIn vendorEventConfigDTOIn, String email) throws IOException;
    void deleteVendorEventConfig(String eventName, String email);
    CompletableFuture<VendorEventConfigDTO> getVendorEventConfigByEventName(String eventName);
    CompletableFuture<List<VendorEventConfigDTO>> getAllVendorEventConfigsByEmail(String email);
    CompletableFuture<VendorEventConfigDTO> updateTotalTickets(String eventName, int totalTickets) throws IOException;
    boolean existsByEventName(String eventName);
    CompletableFuture<Boolean> buyTickets(String eventName);
    CompletableFuture<List<VendorEventConfigDTO>> getAllVendorEventConfigs();
}
