package org.example.ticketingapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sales")
@IdClass(SalesID.class)
@EntityListeners(AuditingEntityListener.class)
public class Sales {
    @Id
    @CreatedDate
    @Column(nullable = false)
    private LocalDate date;

    @Id
    @Column(nullable = false)
    private String vendor;

    @Column(nullable = false)
    private long ticketSales;
}
