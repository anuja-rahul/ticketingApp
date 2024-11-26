package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;

import java.util.concurrent.CompletableFuture;

public interface StatService {
    CompletableFuture<TotalTicketsTimeDtoOut> getTicketPoolStats();
}
