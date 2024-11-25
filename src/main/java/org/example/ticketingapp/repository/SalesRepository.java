package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.Sales;
import org.example.ticketingapp.entity.SalesID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, SalesID> {
}
