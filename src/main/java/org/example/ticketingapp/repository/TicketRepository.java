package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, String> {
    Optional<Ticket> findByEventName(String eventName);
    boolean existsByEventName(String eventName);
}
