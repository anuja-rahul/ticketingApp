package org.example.ticketingapp.mapper;

import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;

public class StatsMapper {
    public static TotalTicketsTimeDtoOut mapToTotalTicketsTimeDtoOut(
            String formattedTime, int totalTickets, int totalCapacity) {
        return new TotalTicketsTimeDtoOut(
                formattedTime,
                totalTickets,
                totalCapacity
        );
    }
}
