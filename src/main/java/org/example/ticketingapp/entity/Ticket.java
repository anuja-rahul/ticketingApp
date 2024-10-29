package org.example.ticketingapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ticket")
public class Ticket {

    @Id
    @Column(unique = true, nullable = false)
    private String eventName;

    @Column(nullable = false)
    private int totalTickets;

    @ManyToOne
    @JoinColumn(name = "vendor_event_config_id", referencedColumnName = "id")
    private VendorEventConfig vendorEventConfig;
}

// TODO: add logic to automatically add a column every time a config is created
