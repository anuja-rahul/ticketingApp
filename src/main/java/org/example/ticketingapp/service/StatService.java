package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.CustomerTicketRecordDTO;
import org.example.ticketingapp.dto.RecordDTO;
import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public interface StatService {
    CompletableFuture<TotalTicketsTimeDtoOut> getTicketPoolStats();
    CompletableFuture<RecordDTO> getRecordSkeletonForToday();

    // History stuff
    CompletableFuture<Boolean> checkHistoryRecordExistence();
    void createHistoryRecord() throws ExecutionException, InterruptedException;
    void updateHistoryRecord() throws ExecutionException, InterruptedException;

    // Sales stuff
    CompletableFuture<Boolean> checkSalesRecordExistence(String vendor);
    void createSalesRecord(String vendor, int ticketSales);
    void updateSalesRecord(String vendor, int ticketSales);
    CompletableFuture<List<RecordDTO>> getHistoryRecords() throws ExecutionException, InterruptedException;

    // UserTickets stuff
    CompletableFuture<List<CustomerTicketRecordDTO>> getCustomerTicketPoolStats();
}
