package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.CustomerTicketDTO;
import org.example.ticketingapp.dto.CustomerTicketDTOIn;
import org.example.ticketingapp.dto.CustomerTicketDtoOut;
import org.example.ticketingapp.entity.CustomerTicketID;

public interface CustomerTicketService {
    CustomerTicketDtoOut createCustomer(CustomerTicketDTO customerTicketDTO);
    CustomerTicketDtoOut getCustomerTicketByCustomerTicketID(CustomerTicketID customerTicketID);
}
