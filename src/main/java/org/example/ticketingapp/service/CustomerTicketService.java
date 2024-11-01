package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.CustomerTicketDTO;
import org.example.ticketingapp.dto.CustomerTicketDtoOut;
import org.example.ticketingapp.entity.CustomerTicketID;

public interface CustomerTicketService {
    CustomerTicketDtoOut createCustomerTicket(CustomerTicketDTO customerTicketDTO);
    CustomerTicketDtoOut getCustomerTicketByCustomerTicketID(CustomerTicketID customerTicketID);
}
