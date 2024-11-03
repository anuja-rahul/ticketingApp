package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.CustomerTicketDTO;
import org.example.ticketingapp.dto.CustomerTicketDtoOut;
import org.example.ticketingapp.entity.CustomerTicket;
import org.example.ticketingapp.entity.CustomerTicketID;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.CustomerTicketMapper;
import org.example.ticketingapp.repository.CustomerTicketRepository;
import org.example.ticketingapp.service.CustomerTicketService;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerTicketServiceImpl implements CustomerTicketService {

    private final CustomerTicketRepository customerTicketRepository;

    @Override
    public CustomerTicketDtoOut createCustomerTicket(CustomerTicketDTO customerTicketDTO) {
        CustomerTicket customerTicket = CustomerTicketMapper.mapToCustomerTicket(customerTicketDTO);
        CustomerTicket savedCustomerTicket =  customerTicketRepository.save(customerTicket);
        return CustomerTicketMapper.mapToCustomerTicketDtoOut(savedCustomerTicket);
    }

    // TODO: Review this sh*t
//    @Override
//    public CustomerTicketDtoOut getCustomerTicketByCustomerTicketID(CustomerTicketID customerTicketID) {
//        CustomerTicket customerTicket = customerTicketRepository.findById(customerTicketID)
//                .orElseThrow(() -> new ResourceNotFoundException("Customer ticket not found: " + customerTicketID));
//        return CustomerTicketMapper.mapToCustomerTicketDtoOut(customerTicket);
//    }

    // TODO: Implement logic for getting all tickets based on customer email

    @Override
    public CustomerTicketDtoOut updateCustomerTicket(
            CustomerTicketID customerTicketID,
            CustomerTicketDTO customerTicketDTO,
            int ticketRetrievalRate) {

        CustomerTicket customerTicket = customerTicketRepository.findById(customerTicketID)
                .orElseThrow(() -> new ResourceNotFoundException("Customer ticket not found: " + customerTicketID));

        customerTicket.setTicketsBought(customerTicket.getTicketsBought() + ticketRetrievalRate);
        CustomerTicket updatedCustomerTicket = customerTicketRepository.save(customerTicket);
        return CustomerTicketMapper.mapToCustomerTicketDtoOut(updatedCustomerTicket);
    }

    @Override
    public boolean existsById(CustomerTicketID customerTicketID) {
        return customerTicketRepository.existsById(customerTicketID);
    }
}
