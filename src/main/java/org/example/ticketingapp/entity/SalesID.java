package org.example.ticketingapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesID implements Serializable {
    private LocalDate date;
    private String vendor;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SalesID salesID = (SalesID) o;
        return Objects.equals(date, salesID.date) && Objects.equals(vendor, salesID.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, vendor);
    }
}
