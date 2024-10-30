package org.example.ticketingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_ticket")
public class UserTicket {
    @EmbeddedId
    private UserTicketId id;

    @ManyToOne
    @MapsId("eventName")
    @JoinColumn(name = "event_name", referencedColumnName = "event_name", nullable = false)
    private VendorEventConfig vendorEventConfig;

    @ManyToOne
    @MapsId("customerEmail")
    @JoinColumn(name = "customer_email", referencedColumnName = "email", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private int ticketCount;
}
