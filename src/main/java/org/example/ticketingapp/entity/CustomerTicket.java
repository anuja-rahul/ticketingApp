package org.example.ticketingapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer_ticket")
@IdClass(CustomerTicketID.class)
@EntityListeners(AuditingEntityListener.class)
public class CustomerTicket {

    @Id
    @Column(nullable = false)
    private String customerEmail;

    @Id
    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private int ticketsBought;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerTicket that = (CustomerTicket) o;
        return customerEmail.equals(that.customerEmail) && eventName.equals(that.eventName);
    }

    @Override
    public int hashCode() {
        int result = customerEmail.hashCode();
        result = 31 * result + eventName.hashCode();
        return result;
    }
}
