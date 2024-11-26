package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;
import org.example.ticketingapp.entity.SalesID;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

public interface StatService {
    CompletableFuture<TotalTicketsTimeDtoOut> getTicketPoolStats();

    CompletableFuture<Boolean> checkSalesRecordExistence(LocalDate date, String vendor);
    CompletableFuture<Boolean> checkHistoryRecordExistence();
}
