package org.example.ticketingapp.dto;

import lombok.Data;

@Data
public class VendorConfigDTO {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;
}
