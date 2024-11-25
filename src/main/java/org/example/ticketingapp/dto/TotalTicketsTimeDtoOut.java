package org.example.ticketingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalTicketsTimeDtoOut {
    private String time;
    private int totalTickets;
    private int totalCapacity;
}
