package org.example.ticketingapp.service.impl;


import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.CustomerDTO;
import org.example.ticketingapp.entity.Customer;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.CustomerMapper;
import org.example.ticketingapp.repository.CustomerRepository;
import org.example.ticketingapp.service.CustomerService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final Lock lock = new ReentrantLock();

    @Async("customerExecutor")
    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO);
        customerRepository.save(customer);
    }

    @Async("customerExecutor")
    @Override
    public CompletableFuture<CustomerDTO> getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + email));
        CustomerDTO result = CustomerMapper.mapToCustomerDto(customer);
        return CompletableFuture.completedFuture(result);
    }


    @Override
    public void updateCustomerPriority(String email) {
        lock.lock();
        try {
            Customer customer = customerRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + email));

            customer.setVip(true);
            customerRepository.save(customer);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean getCustomerPriority(String email) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + email));
        return customer.isVip();
    }
}
