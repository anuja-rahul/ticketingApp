package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.CustomerDTO;
import org.example.ticketingapp.dto.CustomerDtoOut;

import java.util.concurrent.CompletableFuture;


public interface CustomerService {

    void createCustomer(CustomerDTO customerDTO);
    CompletableFuture<CustomerDtoOut> getCustomerByEmail(String email);
    void updateCustomerPriority(String email);
    boolean getCustomerPriority(String email);
}
