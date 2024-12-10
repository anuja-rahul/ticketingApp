package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.auth.AuthenticationRequest;
import org.example.ticketingapp.auth.AuthenticationService;
import org.example.ticketingapp.auth.RegisterRequest;
import org.example.ticketingapp.dto.CustomerDTO;
import org.example.ticketingapp.dto.CustomerTicketDTO;
import org.example.ticketingapp.dto.VendorDTO;
import org.example.ticketingapp.dto.VendorEventConfigDTOIn;
import org.example.ticketingapp.entity.CustomerTicketID;
import org.example.ticketingapp.service.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class SimulateServiceImpl implements SimulateService {

    private VendorService vendorService;
    private CustomerService customerService;
    private UserService userService;
    private final VendorEventConfigService vendorEventConfigService;
    private final CustomerTicketService customerTicketService;
//    private final ThreadPoolService threadPoolService;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authService;

    private final String vendorCredentials = "simulatedVendor@example.domain";
    private final String customerCredentials = "simulatedCustomer@example.domain";
    private final String eventCredentials = "simulatedEvent_";

    private List<String> eventList;
    private List<String> customerList;

    @Override
    public boolean simulate(int userCount, int rate, int cycles) throws IOException, ExecutionException, InterruptedException {
        System.out.println("This is from service layer");
        System.out.println("Simulating " + userCount + " users\n");
        System.out.println("\nValidating and creating users for the simulation\n");

        for (int i = 0; i < userCount; i++) {
            System.out.println(i);
            String currentVendor = vendorCredentials + i;
            String currentCustomer = customerCredentials + i;
            String currentEvent = eventCredentials + i;
            eventList.add(currentEvent);
            customerList.add(currentCustomer);

            System.out.println("\n\nCurrent vendor: " + currentVendor);
            if (!checkUserExistence(currentVendor)) {
                createVendor(currentVendor);
            }
            System.out.println("\n\nCurrent customer: " + currentCustomer);
            if (!checkUserExistence(currentCustomer)) {
                createCustomer(currentCustomer);
            }
            System.out.println("\n\nCurrent event: " + currentEvent);
            if (!checkEventExistence(currentEvent)) {
                createEvent(currentVendor, currentEvent);
            }
        }
        System.out.println("\n\n" + eventList + "\n");
        System.out.println("\n" + customerList + "\n");

        runSimulation(rate, cycles);


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

    // producer consumer pattern

    @Override
    public void addTickets(String eventName, int rate, int cycles) throws IOException, ExecutionException, InterruptedException {
        try {
            vendorEventConfigService.updateTotalTickets(eventName, rate * (cycles + 1) * eventList.size());
        } finally {
            System.out.println("\nTotal tickets updated on event " + eventName + "\n");
        }
    }

    @Override
    public void buyTickets(String eventName, String email, int rate) throws IOException, ExecutionException, InterruptedException {
        try {
            CustomerTicketID customerTicketID = new CustomerTicketID(email, eventName);
            boolean customerTicketExists = customerTicketService.existsById(customerTicketID);
            CustomerTicketDTO customerTicketDTO = new CustomerTicketDTO(
                    email,
                    eventName,
                    rate);
            boolean reduced = vendorEventConfigService.buyTickets(eventName).get();
            if (reduced) {
                if (!customerTicketExists) {
                    // create a new customerTicket
                    customerTicketService.createCustomerTicket(customerTicketDTO);
                } else {
                    // update an existing customerTicket
                    customerTicketService.updateCustomerTicket(
                                    customerTicketID, customerTicketDTO, rate
                            );
                }
            }
        } finally {
            System.out.println("\nCustomer :" + email + " bought " + rate + " tickets from " + eventName + "\n");
        }
    }

    // run simulation
    @Override
    public void runSimulation(int rate, int cycles) throws InterruptedException {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {

            for (String event : eventList) {
                Runnable addTicketsTask = () -> {
                    try {
                        addTickets(event, rate, cycles);
                    } catch (ExecutionException | IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                };
                executorService.submit(addTicketsTask);

                for (int i = 0; i < cycles; i++) {
                    for (String customer : customerList) {
                        Thread.sleep(20);
                        Runnable buyTicketsTask = () -> {
                            try {
                                buyTickets(event, customer, rate);
                            } catch (ExecutionException | IOException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        };
                        executorService.submit(buyTicketsTask);
                    }
                }
            }
            executorService.shutdown();
            if (!executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                System.err.println("\nExecutor did not terminate within the expected timeframe\n");
            }
        }
    }


}
