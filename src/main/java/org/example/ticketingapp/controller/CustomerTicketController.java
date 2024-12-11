package org.example.ticketingapp.controller;

import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.CustomerTicketDTO;
import org.example.ticketingapp.dto.CustomerTicketDtoOut;
import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.entity.CustomerTicketID;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.ResourceCapacityException;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.repository.UserRepository;
import org.example.ticketingapp.service.CustomerTicketService;
import org.example.ticketingapp.service.VendorEventConfigService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Controller class for handling customer ticket-related requests.
 * This class provides endpoints for managing customer tickets.
 * It uses {@link CustomerTicketService} and {@link VendorEventConfigService} to perform operations related to tickets and events.
 * The class is annotated with {@link RestController} to indicate that it is a RESTful web service controller.
 * It is also annotated with {@link CrossOrigin} to allow cross-origin requests.
 * The base URL for all endpoints in this class is "/api/ticket".
 */
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/ticket")
public class CustomerTicketController {

    private CustomerTicketService customerTicketService;
    private VendorEventConfigService vendorEventConfigService;
    private final UserRepository userRepository;
    private final JwtService jwtService;


    /**
     * Add tickets if logged in as a customer.
     * Creates new tickets if no pre-existing tickets are found.
     *
     * @param eventName the name of the event for which tickets are being added
     * @return a {@link ResponseEntity} indicating the result of the operation
     */
    @Operation(summary = "Add tickets if logged in as a customer, " +
            "creates a new tickets if no pre existing tickets are found")
    @PostMapping("add/{eventName}")
    public ResponseEntity<CustomerTicketDtoOut> addCustomerTicket(
            @RequestHeader("Authorization") String token,
            @PathVariable String eventName) {
        try {

            // get email/user from jwt token
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Claims claims = jwtService.extractAllClaims(token);
            String email = claims.getSubject();
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            if ("customer".equalsIgnoreCase(user.getRole().name())) {
                CustomerTicketID customerTicketID = new CustomerTicketID(email, eventName);

                // check for existence of customer ticket, config and ticket
                boolean customerTicketExists = customerTicketService.existsById(customerTicketID);
                boolean configExists = vendorEventConfigService.existsByEventName(eventName);

                if (configExists) {
                    // get ticket retrieval rate
                    int ticketRetrievalRate = getTicketRetrievalRate(eventName);
                    CustomerTicketDTO customerTicketDTO = new CustomerTicketDTO(
                            email,
                            eventName,
                            ticketRetrievalRate);

                    // logic to update vendor event config
                    boolean reduced = vendorEventConfigService.buyTickets(eventName).get();
                    System.out.println("Customer: " + email + " bought " + ticketRetrievalRate +
                            " tickets for the event: " + eventName);
                    if (reduced) {

                        if(!customerTicketExists) {
                            // create a new customer ticket (async)
                            CompletableFuture<CustomerTicketDtoOut> newCustomerTicket = customerTicketService
                                    .createCustomerTicket(customerTicketDTO);
                            return new ResponseEntity<>(newCustomerTicket.get(), HttpStatus.OK);
                        } else {
                            // update existing customer ticket (async)
                            CompletableFuture<CustomerTicketDtoOut> updatedCustomerTicketDtoOut = customerTicketService
                                    .updateCustomerTicket(
                                            customerTicketID, customerTicketDTO, ticketRetrievalRate);
                            return new ResponseEntity<>(updatedCustomerTicketDtoOut.get(), HttpStatus.OK);
                            }
                    }
                    else {
                        return new ResponseEntity<>(HttpStatus.CONFLICT);
                    }

                }
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ResourceCapacityException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Get a list of all the tickets bought by the user, if logged in as a customer.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the list of tickets bought by the user
     */
    @Operation(summary = "Get a list of all the tickets bought by the user, if logged in as a customer")
    @GetMapping("/all")
    public ResponseEntity<List<CustomerTicketDtoOut>> getAllTicketsByEmail(
            @RequestHeader("Authorization") String token) {

        // get email/user from jwt token
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        try {

            if ("customer".equalsIgnoreCase(user.getRole().name())) {
                // check for existence of customer tickets by email
                CompletableFuture<List<CustomerTicketDtoOut>> customerTicketDtoOuts = customerTicketService.getCustomerTicketsByEmail(email);
                return ResponseEntity.ok(customerTicketDtoOuts.get());
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Delete all tickets bought by the user for a specific event, if logged in as a customer.
     *
     * @param token the JWT token included in the request header
     * @param eventName the name of the event for which tickets are being deleted
     * @return a {@link ResponseEntity} indicating the result of the operation
     */
    @Operation(summary = "Delete all tickets bought by the user, if logged in as a customer")
    @DeleteMapping("/{eventName}")
    public ResponseEntity<Void> deleteCustomerTicket(
            @RequestHeader("Authorization") String token,
            @PathVariable String eventName) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        try{

            if ("customer".equalsIgnoreCase(user.getRole().name())) {
                CustomerTicketID customerTicketID = new CustomerTicketID(email, eventName);
                customerTicketService.deleteCustomerTickets(customerTicketID).get();
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }


        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieve the ticket retrieval rate for a specific event.
     *
     * @param eventName the name of the event for which the ticket retrieval rate is being retrieved
     * @return the ticket retrieval rate for the specified event
     * @throws ExecutionException if an error occurs during the asynchronous computation
     * @throws InterruptedException if the current thread is interrupted while waiting
     */
    private int getTicketRetrievalRate(String eventName) throws ExecutionException, InterruptedException {
        CompletableFuture<VendorEventConfigDTO> vendorEventConfigDTO = vendorEventConfigService.getVendorEventConfigByEventName(eventName);
        return vendorEventConfigDTO.get().getCustomerRetrievalRate();
    }
}
