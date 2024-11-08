package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.CustomerDTO;
import org.example.ticketingapp.dto.CustomerDtoOut;
import org.example.ticketingapp.dto.CustomerTicketDtoOut;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;


public interface CustomerService {

    void createCustomer(CustomerDTO customerDTO);
    CompletableFuture<CustomerDtoOut> getCustomerByEmail(String email);
    void updateCustomerPriority(String email);
    boolean getCustomerPriority(String email);
}
