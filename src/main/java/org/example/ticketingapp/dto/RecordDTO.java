package org.example.ticketingapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecordDTO {
    private LocalDate date;
    private long totalUsers;
    private long totalSales;
}
