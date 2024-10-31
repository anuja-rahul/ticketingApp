package org.example.ticketingapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTicketID implements Serializable {
    private String customerEmail;
    private String eventName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerTicketID that = (CustomerTicketID) o;
        return customerEmail.equals(that.customerEmail) && eventName.equals(that.eventName);
    }

    @Override
    public int hashCode() {
        int result = customerEmail.hashCode();
        result = 31 * result + eventName.hashCode();
        return result;
    }
}
