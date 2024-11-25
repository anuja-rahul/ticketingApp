package org.example.ticketingapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "history")
@EntityListeners(AuditingEntityListener.class)
public class History {
    @Id
    @CreatedDate
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private long totalUsers;

    @Column(nullable = false)
    private long totalSales;
}
