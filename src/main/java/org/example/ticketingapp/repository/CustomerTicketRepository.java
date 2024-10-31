package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.CustomerTicket;
import org.example.ticketingapp.entity.CustomerTicketID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTicketRepository extends JpaRepository<CustomerTicket, CustomerTicketID> {
}
