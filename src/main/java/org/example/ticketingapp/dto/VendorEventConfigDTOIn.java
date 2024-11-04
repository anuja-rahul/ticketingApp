package org.example.ticketingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorEventConfigDTOIn {
    private long id;
    private String eventName;
//    private int totalTickets;
//    private int ticketReleaseRate;
//    private int customerRetrievalRate;
//    private int maxTicketCapacity;
}
