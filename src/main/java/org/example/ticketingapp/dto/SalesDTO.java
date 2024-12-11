package org.example.ticketingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesDTO {
    private LocalDate date;
    private String vendor;
    private long ticketSales;
}
