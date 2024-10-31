package org.example.ticketingapp.mapper;

import org.example.ticketingapp.dto.TicketDTO;
import org.example.ticketingapp.entity.Ticket;

public class TicketMapper {

    public static TicketDTO mapToTicketDto(Ticket ticket) {
        return new TicketDTO(
                ticket.getEventName(),
                ticket.getTotalTickets(),
                ticket.getVendorEventConfig()
        );
    }

    public static Ticket mapToTicket(TicketDTO ticketDTO) {
        return new Ticket(
                ticketDTO.getEventName(),
                ticketDTO.getTotalTickets(),
                ticketDTO.getVendorEventConfig()
        );
    }
}
