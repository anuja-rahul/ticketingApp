package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.auth.AuthenticationRequest;
import org.example.ticketingapp.auth.AuthenticationService;
import org.example.ticketingapp.auth.RegisterRequest;
import org.example.ticketingapp.dto.CustomerDTO;
import org.example.ticketingapp.dto.VendorDTO;
import org.example.ticketingapp.dto.VendorEventConfigDTOIn;
import org.example.ticketingapp.service.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class SimulateServiceImpl implements SimulateService {
    private VendorService vendorService;
    private CustomerService customerService;
    private UserService userService;
    private final VendorEventConfigService vendorEventConfigService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authService;

    private final String vendorCredentials = "simulatedVendor@example.domain";
    private final String customerCredentials = "simulatedCustomer@example.domain";
    private final String eventCredentials = "simulatedEvent_";

    @Override
    public boolean simulate(int userCount) throws IOException, ExecutionException, InterruptedException {
        System.out.println("This is from service layer");
        System.out.println("Simulating " + userCount + " users\n");

        for (int i = 0; i < userCount; i++) {
            System.out.println(i);
            String currentVendor = vendorCredentials + i;
            String currentCustomer = customerCredentials + i;
            String currentEvent = eventCredentials + i;

            System.out.println("\n\nCurrent vendor: " + currentVendor);
            if (!checkUserExistence(currentVendor)) {
                String currentToken = createVendor(currentVendor);
            }
            System.out.println("\n\nCurrent customer: " + currentCustomer);
            if (!checkUserExistence(currentCustomer)) {
                String currentToken = createCustomer(currentCustomer);
            }
            System.out.println("\n\nCurrent event: " + currentEvent);
            if (!checkEventExistence(currentEvent)) {
                createEvent(currentVendor, currentEvent);
            }
        }


        return true;
    }

    // validate

    @Override
    public boolean checkUserExistence(String userName) {
        return userService.existsUserByEmail(userName);
    }

    @Override
    public String getToken(String credentials) {
        AuthenticationRequest request = new AuthenticationRequest(credentials, credentials);
        return authService.authenticate(request).getToken();
    }

    @Override
    public boolean checkEventExistence(String eventName) {
        return vendorEventConfigService.existsByEventName(eventName);
    }

    // create

    @Override
    public String createVendor(String credentials) {
        VendorDTO vendorDTO = new VendorDTO();
        RegisterRequest request = new RegisterRequest(credentials, credentials, credentials, "vendor");
        vendorDTO.setName(credentials);
        vendorDTO.setEmail(credentials);
        vendorDTO.setPassword(passwordEncoder.encode(vendorCredentials));
        vendorService.createVendor(vendorDTO);
        return authService.register(request).getToken();
    }

    @Override
    public String createCustomer(String credentials) {
        CustomerDTO customerDTO = new CustomerDTO();
        RegisterRequest request = new RegisterRequest(credentials, credentials, credentials, "customer");
        customerDTO.setName(credentials);
        customerDTO.setEmail(credentials);
        customerDTO.setPassword(passwordEncoder.encode(customerCredentials));
        customerService.createCustomer(customerDTO);
        return authService.register(request).getToken();
    }

    @Override
    public void createEvent(String vendorEmail, String eventName) throws IOException, ExecutionException, InterruptedException {
        VendorEventConfigDTOIn vendorEventConfigDTOIn = new VendorEventConfigDTOIn();
        vendorEventConfigDTOIn.setEventName(eventName);
        vendorEventConfigService.createVendorEventConfig(vendorEventConfigDTOIn, vendorEmail).get();
    }

    @Override
    public void addTickets(String eventName) throws IOException, ExecutionException, InterruptedException {

    }


}
