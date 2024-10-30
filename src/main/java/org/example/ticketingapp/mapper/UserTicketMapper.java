package org.example.ticketingapp.mapper;

import org.example.ticketingapp.dto.UserTicketDTO;
import org.example.ticketingapp.dto.UserTicketDTOIn;

public class UserTicketMapper {
    public static UserTicketDTO mapToUserTicketDTO(UserTicketDTOIn userTicketDTOIn, String email) {
        return new UserTicketDTO(
                userTicketDTOIn.getEventName(),
                email,
                userTicketDTOIn.getTicketCount()
        );
    }
}
