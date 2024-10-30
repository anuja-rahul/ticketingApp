package org.example.ticketingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ticketingapp.dto.UserTicketDTO;
import org.example.ticketingapp.entity.Customer;
import org.example.ticketingapp.entity.UserTicket;
import org.example.ticketingapp.entity.UserTicketId;
import org.example.ticketingapp.entity.VendorEventConfig;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.repository.CustomerRepository;
import org.example.ticketingapp.repository.UserTicketRepository;
import org.example.ticketingapp.repository.VendorEventConfigRepository;
import org.example.ticketingapp.service.UserTicketService;
import org.springframework.stereotype.Service;

// TODO: ERROR was tracked to this class, maybe not

@Service
@RequiredArgsConstructor
public class UserTicketServiceImpl implements UserTicketService {
    private final CustomerRepository customerRepository;
    private final UserTicketRepository userTicketRepository;
    private final VendorEventConfigRepository vendorEventConfigRepository;

    @Override
    public UserTicketDTO createUserTicket(UserTicketDTO userTicketDTO) {

        // TODO: error must be here, maybe not

        Customer customer = customerRepository.findByEmail(userTicketDTO.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + userTicketDTO.getEmail()));

        VendorEventConfig vendorEventConfig = vendorEventConfigRepository.findByEventName(userTicketDTO.getEventName())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found: " + userTicketDTO.getEventName()));

        UserTicketId userTicketId = new UserTicketId(userTicketDTO.getEventName(), userTicketDTO.getEmail());

        UserTicket userTicket = new UserTicket(userTicketId, vendorEventConfig, customer, userTicketDTO.getTicketCount());
        userTicketRepository.save(userTicket);
        return userTicketDTO;
    }

}