package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.CustomerDTO;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;


public interface CustomerService {

    void createCustomer(CustomerDTO customerDTO);
    CompletableFuture<CustomerDTO> getCustomerByEmail(String email);
    void updateCustomerPriority(String email);
    boolean getCustomerPriority(String email);
}
