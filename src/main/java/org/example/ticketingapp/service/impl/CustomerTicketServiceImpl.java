package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.CustomerTicketDTO;
import org.example.ticketingapp.dto.CustomerTicketDtoOut;
import org.example.ticketingapp.entity.CustomerTicket;
import org.example.ticketingapp.entity.CustomerTicketID;
import org.example.ticketingapp.mapper.CustomerTicketMapper;
import org.example.ticketingapp.repository.CustomerTicketRepository;
import org.example.ticketingapp.service.CustomerTicketService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerTicketServiceImpl implements CustomerTicketService {

    private CustomerTicketRepository customerTicketRepository;

    @Override
    public CustomerTicketDtoOut createCustomerTicket(CustomerTicketDTO customerTicketDTO) {
        CustomerTicket customerTicket = CustomerTicketMapper.mapToCustomerTicket(customerTicketDTO);
        CustomerTicket savedCustomerTicket =  customerTicketRepository.save(customerTicket);
        return CustomerTicketMapper.mapToCustomerTicketDtoOut(savedCustomerTicket);
    }

    @Override
    public CustomerTicketDtoOut getCustomerTicketByCustomerTicketID(CustomerTicketID customerTicketID) {
        return null;
    }
}
