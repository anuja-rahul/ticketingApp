package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.CustomerTicketDTO;
import org.example.ticketingapp.dto.CustomerTicketDtoOut;
import org.example.ticketingapp.entity.CustomerTicketID;

import java.util.Optional;

public interface CustomerTicketService {
    CustomerTicketDtoOut createCustomerTicket(CustomerTicketDTO customerTicketDTO);
    boolean existsById(CustomerTicketID customerTicketID);
    CustomerTicketDtoOut getCustomerTicketByCustomerTicketID(CustomerTicketID customerTicketID);
}
