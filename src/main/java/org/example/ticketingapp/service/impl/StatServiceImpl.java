package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;
import org.example.ticketingapp.entity.History;
import org.example.ticketingapp.entity.Sales;
import org.example.ticketingapp.entity.SalesID;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.StatsMapper;
import org.example.ticketingapp.repository.HistoryRepository;
import org.example.ticketingapp.repository.SalesRepository;
import org.example.ticketingapp.repository.UserRepository;
import org.example.ticketingapp.repository.VendorEventConfigRepository;
import org.example.ticketingapp.service.StatService;
import org.example.ticketingapp.utility.BaseUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class StatServiceImpl implements StatService {
    private final VendorEventConfigRepository vendorEventConfigRepository;
    private final HistoryRepository historyRepository;
    private final SalesRepository salesRepository;
    private final UserRepository userRepository;

    // vendorEventConfig stuff

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

    // Sales stuff

    @Override
    @Async("taskExecutor")
    public CompletableFuture<Boolean> checkSalesRecordExistence(String vendor) {
        LocalDate date = LocalDate.now();
        SalesID salesID = StatsMapper.mapToSalesID(date, vendor);
        boolean result = salesRepository.existsById(salesID);
        return CompletableFuture.completedFuture(result);
    }

    @Override
    @Async("taskExecutor")
    public CompletableFuture<Void> createSalesRecord(String vendor, Long ticketSales) {
        LocalDate date = LocalDate.now();
        SalesID salesID = StatsMapper.mapToSalesID(date, vendor);
        Sales sales = StatsMapper.mapToSales(salesID, ticketSales);
        salesRepository.save(sales);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> updateSalesRecord(String vendor, Long ticketSales) {
        return null;
    }

    // History stuff

    @Override
    @Async("taskExecutor")
    public CompletableFuture<Boolean> checkHistoryRecordExistence() {
        LocalDate date = LocalDate.now();
        boolean result = historyRepository.existsById(date);
        return CompletableFuture.completedFuture(result);
    }

    @Override
    public CompletableFuture<Void> createHistoryRecord() {
        LocalDate date = LocalDate.now();

        // get total users and total sales
        long totalUsers = userRepository.count();
        int totalSalesToday = salesRepository.getTotalSalesByDate(date);

        History history = new History(date, totalUsers, totalSalesToday);
        historyRepository.save(history);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> updateHistoryRecord() {
        // get total users, total sales and today
        LocalDate today = LocalDate.now();
        long totalUsers = userRepository.count();
        int totalSalesToday = salesRepository.getTotalSalesByDate(today);
        boolean exists = historyRepository.existsById(today);

        if (exists) {
            History historyRecord = historyRepository.findById(today)
                    .orElseThrow(() -> new ResourceNotFoundException("Record not found"));
            historyRecord.setTotalUsers(totalUsers);
            historyRecord.setTotalSales(totalSalesToday);
            historyRepository.save(historyRecord);
        } else {
            createHistoryRecord();
        }
        return CompletableFuture.completedFuture(null);
    }
}
