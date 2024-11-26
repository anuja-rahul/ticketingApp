package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;
import org.example.ticketingapp.mapper.StatsMapper;
import org.example.ticketingapp.repository.VendorEventConfigRepository;
import org.example.ticketingapp.service.StatService;
import org.example.ticketingapp.utility.BaseUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class StatServiceImpl implements StatService {
    private final VendorEventConfigRepository vendorEventConfigRepository;


    @Override
    @Async("taskExecutor")
    public CompletableFuture<TotalTicketsTimeDtoOut> getTicketPoolStats() {
        int totalTickets = vendorEventConfigRepository.findTotalTicketPool();
        int totalTicketCapacity = vendorEventConfigRepository.findTotalTicketPoolCapacity();
        String formattedTime = BaseUtils.getFormattedTimeByMinutes();
        TotalTicketsTimeDtoOut result = StatsMapper.mapToTotalTicketsTimeDtoOut(
                formattedTime, totalTickets, totalTicketCapacity);
        return CompletableFuture.completedFuture(result);
    }
}
