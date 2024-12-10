package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface HistoryRepository extends JpaRepository<History, LocalDate> {
}
