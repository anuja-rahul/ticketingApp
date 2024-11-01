package org.example.ticketingapp.mapper;

import org.example.ticketingapp.dto.CustomerTicketDTO;
import org.example.ticketingapp.dto.CustomerTicketDtoOut;
import org.example.ticketingapp.entity.CustomerTicket;

public class CustomerTicketMapper {

    public static CustomerTicket mapToCustomerTicket(CustomerTicketDTO customerTicketDTO) {
        return new CustomerTicket(
                customerTicketDTO.getCustomerEmail(),
                customerTicketDTO.getEventName(),
                customerTicketDTO.getTicketsBought()
        );
    }

    public static CustomerTicketDtoOut mapToCustomerTicketDtoOut(CustomerTicket customerTicket) {
        return new CustomerTicketDtoOut(
                customerTicket.getCustomerEmail(),
                customerTicket.getEventName(),
                customerTicket.getTicketsBought()
        );
    }
}
