package org.example.ticketingapp.mapper;

import org.example.ticketingapp.dto.RecordDTO;
import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;
import org.example.ticketingapp.entity.History;
import org.example.ticketingapp.entity.Sales;
import org.example.ticketingapp.entity.SalesID;

import java.time.LocalDate;

public class StatsMapper {
    public static TotalTicketsTimeDtoOut mapToTotalTicketsTimeDtoOut(
            String formattedTime, int totalTickets, int totalCapacity) {
        return new TotalTicketsTimeDtoOut(
                formattedTime,
                totalTickets,
                totalCapacity
        );
    }

    public static SalesID mapToSalesID(LocalDate date, String vendor) {
        return new SalesID(date, vendor);
    }

    public static Sales mapToSales(SalesID salesID, long ticketSales) {
        return new Sales(
                salesID.getDate(),
                salesID.getVendor(),
                ticketSales
        );
    }

    public static RecordDTO mapToRecordDTO(History history) {
        return new RecordDTO(
                history.getDate(),
                history.getTotalUsers(),
                history.getTotalSales()
        );
    }
}
