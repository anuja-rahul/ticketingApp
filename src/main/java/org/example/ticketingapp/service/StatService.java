package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;

import java.util.concurrent.CompletableFuture;

public interface StatService {
    CompletableFuture<TotalTicketsTimeDtoOut> getTicketPoolStats();

    // History stuff
    CompletableFuture<Boolean> checkHistoryRecordExistence();
    CompletableFuture<Void> createHistoryRecord();
    CompletableFuture<Void> updateHistoryRecord();

    // Sales stuff
    CompletableFuture<Boolean> checkSalesRecordExistence(String vendor);
    CompletableFuture<Void> createSalesRecord(String vendor, Long ticketSales);
    CompletableFuture<Void> updateSalesRecord(String vendor, Long ticketSales);
}
