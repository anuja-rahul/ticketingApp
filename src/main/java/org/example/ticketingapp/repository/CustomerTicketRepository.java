package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.CustomerTicket;
import org.example.ticketingapp.entity.CustomerTicketID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface CustomerTicketRepository extends JpaRepository<CustomerTicket, CustomerTicketID> {

    @NonNull
    Optional<CustomerTicket> findById(@NonNull CustomerTicketID customerTicketID);
    boolean existsById(@NonNull CustomerTicketID customerTicketID);
}
