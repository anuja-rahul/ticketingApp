package org.example.ticketingapp.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;
import org.example.ticketingapp.service.VendorEventConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/stats")
public class StatsController {
    private VendorEventConfigService vendorEventConfigService;


    @Operation(summary = "Returns all the current ticket pool stats")
    @GetMapping("/ticketPool")
    public ResponseEntity<TotalTicketsTimeDtoOut> getTotalTicketPoolStats() throws ExecutionException, InterruptedException {
        CompletableFuture<TotalTicketsTimeDtoOut> result = vendorEventConfigService.getTicketPoolStats();
        return ResponseEntity.ok(result.get());
    }
}
