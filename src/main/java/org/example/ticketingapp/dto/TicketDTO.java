package org.example.ticketingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ticketingapp.entity.VendorEventConfig;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private String eventName;
    private int totalTickets;
    private VendorEventConfig vendorEventConfig;
}
