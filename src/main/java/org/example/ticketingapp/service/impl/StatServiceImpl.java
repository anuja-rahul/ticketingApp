package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.RecordDTO;
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
import java.util.concurrent.ExecutionException;

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
    public void createSalesRecord(String vendor, int ticketSales) {
        LocalDate date = LocalDate.now();
        SalesID salesID = StatsMapper.mapToSalesID(date, vendor);
        Sales sales = StatsMapper.mapToSales(salesID, ticketSales);
        salesRepository.save(sales);
        CompletableFuture.completedFuture(null);
    }

    @Override
    @Async("taskExecutor")
    public void updateSalesRecord(String vendor, int ticketSales) {
        LocalDate date = LocalDate.now();
        SalesID salesID = StatsMapper.mapToSalesID(date, vendor);
        boolean exists = salesRepository.existsById(salesID);

        if (exists) {
            Sales salesRecord = salesRepository.findById(salesID)
                    .orElseThrow(() -> new ResourceNotFoundException("Sales record not found"));
            salesRecord.setTicketSales(salesRecord.getTicketSales() + ticketSales);
            salesRepository.save(salesRecord);
        } else {
            createSalesRecord(vendor, ticketSales);
        }
        CompletableFuture.completedFuture(null);
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
    public void createHistoryRecord() throws ExecutionException, InterruptedException {
        // get total users and total sales
        RecordDTO recordDTO = getRecordSkeletonForToday().get();

        History history = new History(recordDTO.getDate(), recordDTO.getTotalUsers(), recordDTO.getTotalSales());
        historyRepository.save(history);
        CompletableFuture.completedFuture(null);
    }

    @Override
    public void updateHistoryRecord() throws ExecutionException, InterruptedException {
        // get total users, total sales and today
        RecordDTO recordDTO = getRecordSkeletonForToday().get();
        boolean exists = historyRepository.existsById(recordDTO.getDate());

        if (exists) {
            History historyRecord = historyRepository.findById(recordDTO.getDate())
                    .orElseThrow(() -> new ResourceNotFoundException("Record not found"));
            historyRecord.setTotalUsers(recordDTO.getTotalUsers());
            historyRecord.setTotalSales(recordDTO.getTotalSales());
            historyRepository.save(historyRecord);
        } else {
            createHistoryRecord();
        }
        CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<RecordDTO> getRecordSkeletonForToday() {
        LocalDate today = LocalDate.now();
        long totalUsers = userRepository.count();
        int totalSalesToday = salesRepository.getTotalSalesByDate(today);
        RecordDTO record = new RecordDTO(today, totalUsers, totalSalesToday);
        return CompletableFuture.completedFuture(record);
    }
}
