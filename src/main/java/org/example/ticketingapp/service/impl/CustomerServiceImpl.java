package org.example.ticketingapp.service.impl;


import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.CustomerDTO;
import org.example.ticketingapp.entity.Customer;
import org.example.ticketingapp.mapper.CustomerMapper;
import org.example.ticketingapp.repository.CustomerRepository;
import org.example.ticketingapp.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + email));
        return CustomerMapper.mapToCustomerDto(customer);
    }
}
