package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.Sales;
import org.example.ticketingapp.entity.SalesID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SalesRepository extends JpaRepository<Sales, SalesID> {

    @Query("SELECT COALESCE(SUM(s.ticketSales), 0) FROM sales s WHERE s.date = :today")
    Integer getTotalSalesByDate(LocalDate today);
}
