package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.TicketDTO;

public interface TicketService {
    void createTicket(TicketDTO ticketDTO);
    TicketDTO getTicketByEventName(String eventName);
}
