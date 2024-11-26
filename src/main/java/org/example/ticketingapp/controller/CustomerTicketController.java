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
import org.example.ticketingapp.service.StatService;
import org.example.ticketingapp.service.VendorEventConfigService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/ticket")
public class CustomerTicketController {

    private CustomerTicketService customerTicketService;
    private VendorEventConfigService vendorEventConfigService;
    private StatService statService;
    private final UserRepository userRepository;
    private final JwtService jwtService;


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

    private int getTicketRetrievalRate(String eventName) throws ExecutionException, InterruptedException {
        CompletableFuture<VendorEventConfigDTO> vendorEventConfigDTO = vendorEventConfigService.getVendorEventConfigByEventName(eventName);
        return vendorEventConfigDTO.get().getCustomerRetrievalRate();
    }
}
