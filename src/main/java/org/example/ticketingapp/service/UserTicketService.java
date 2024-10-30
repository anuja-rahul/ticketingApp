package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.UserTicketDTO;

public interface UserTicketService {
    UserTicketDTO createUserTicket(UserTicketDTO userTicketDTO);
//    UserTicketDTO getUserTicketById(String eventName, String email);
//    void deleteUserTicket(String eventName, String email);
//    void updateUserTicket(String eventName, String email, int ticketCount);
//    void getUserTicket(String eventName, String email);
//    void getAllUserTickets();
}
