package org.example.ticketingapp.repository;

import jakarta.validation.constraints.NotNull;
import org.example.ticketingapp.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History, LocalDate> {
}
