package org.example.ticketingapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer_ticket")
@IdClass(CustomerTicketID.class)
public class CustomerTicket {

    @Id
    @Column(nullable = false)
    private String customerEmail;

    @Id
    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private int ticketsBought;

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
