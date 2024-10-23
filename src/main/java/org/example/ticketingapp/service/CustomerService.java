package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.CustomerDTO;


public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerByEmail(String email);
}
