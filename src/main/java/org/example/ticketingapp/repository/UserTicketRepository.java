package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.UserTicket;
import org.example.ticketingapp.entity.UserTicketId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTicketRepository extends JpaRepository<UserTicket, UserTicketId> {
}
