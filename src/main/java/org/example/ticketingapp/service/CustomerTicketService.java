package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.CustomerTicketDTO;
import org.example.ticketingapp.dto.CustomerTicketDtoOut;
import org.example.ticketingapp.entity.CustomerTicketID;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CustomerTicketService {
    CompletableFuture<CustomerTicketDtoOut> createCustomerTicket(CustomerTicketDTO customerTicketDTO);
    boolean existsById(CustomerTicketID customerTicketID);

    CompletableFuture<CustomerTicketDtoOut> updateCustomerTicket(
            CustomerTicketID customerTicketID,
            CustomerTicketDTO customerTicketDTO,
            int ticketRetrievalRate) throws InterruptedException;
    CompletableFuture<CustomerTicketDtoOut> updateTicket(CustomerTicketID customerTicketID, int ticketRetrievalRate);

    CustomerTicketDtoOut getCustomerTicketByCustomerTicketID(CustomerTicketID customerTicketID);
    CompletableFuture<List<CustomerTicketDtoOut>> getCustomerTicketsByEmail(String email);
    CompletableFuture<Void> deleteCustomerTickets(CustomerTicketID customerTicketID);
}
