package org.example.ticketingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vendor_event_config")
public class VendorEventConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(name = "event_name", unique = true, nullable = false)
    private String eventName;

    @Column
    private int totalTickets;

    @Column
    private int ticketReleaseRate;

    @Column
    private int customerRetrievalRate;

    @Column
    private int maxTicketCapacity;
}
