package org.example.ticketingapp.repository;

import org.example.ticketingapp.dto.CustomerTicketRecordDTO;
import org.example.ticketingapp.entity.CustomerTicket;
import org.example.ticketingapp.entity.CustomerTicketID;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface CustomerTicketRepository extends JpaRepository<CustomerTicket, CustomerTicketID> {

    @NonNull
    Optional<CustomerTicket> findById(@NonNull CustomerTicketID customerTicketID);
    boolean existsById(@NonNull CustomerTicketID customerTicketID);
    List<CustomerTicket> getCustomerTicketByCustomerEmail(@NonNull String customerEmail, Sort sort);

    @Query("SELECT SUM(ct.ticketsBought) FROM customer_ticket ct WHERE ct.customerEmail = :customerEmail")
    Integer findTotalTicketsBoughtByCustomerEmail(@NonNull String customerEmail);

    @Query("SELECT new org.example.ticketingapp.dto.CustomerTicketRecordDTO(ct.eventName, SUM(ct.ticketsBought)) " +
            "FROM customer_ticket ct GROUP BY ct.eventName")
    List<CustomerTicketRecordDTO> findTotalTicketsBoughtGroupedByEvent();
}
