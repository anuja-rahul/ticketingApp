package org.example.ticketingapp.mapper;

import org.example.ticketingapp.dto.CustomerDTO;
import org.example.ticketingapp.dto.UserDTO;
import org.example.ticketingapp.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO mapToCustomerDto(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.isVip()
        );
    }

    public static Customer mapToCustomer(CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getEmail(),
                customerDTO.getPassword(),
                customerDTO.isVip()
        );
    }
}

