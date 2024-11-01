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
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.repository.UserRepository;
import org.example.ticketingapp.service.CustomerTicketService;
import org.example.ticketingapp.service.VendorEventConfigService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/ticket")
public class CustomerTicketController {

    private CustomerTicketService customerTicketService;
    private VendorEventConfigService vendorEventConfigService;
    private final UserRepository userRepository;
    private final JwtService jwtService;


    @Operation(summary = "Add a ticket if logged in as a customer, creates a new tickets if no pre existing tickets are found")
    @PostMapping("add/{eventName}")
    public ResponseEntity<CustomerTicketDtoOut> addCustomerTicket(
            @RequestHeader("Authorization") String token,
            @PathVariable String eventName) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            Claims claims = jwtService.extractAllClaims(token);
            String email = claims.getSubject();

            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            if ("customer".equalsIgnoreCase(user.getRole().name())) {
                CustomerTicketID customerTicketID = new CustomerTicketID(email, eventName);

                boolean exists = customerTicketService.existsById(customerTicketID);
                boolean configExists = vendorEventConfigService.existsByEventName(eventName);

                int ticketRetrievalRate = getTicketRetrievalRate(eventName);
                CustomerTicketDTO customerTicketDTO = new CustomerTicketDTO(
                        email,
                        eventName,
                        ticketRetrievalRate);

                if (configExists) {
                    if(!exists) {
                        CustomerTicketDtoOut newCustomerTicket = customerTicketService.createCustomerTicket(customerTicketDTO);
                        return new ResponseEntity<>(newCustomerTicket, HttpStatus.CREATED);
                    } else {
                        CustomerTicketDtoOut updatedCustomerTicketDtoOut = customerTicketService.updateCustomerTicket(
                                customerTicketID, customerTicketDTO, ticketRetrievalRate);
                        return new ResponseEntity<>(updatedCustomerTicketDtoOut, HttpStatus.OK);
                    }
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }

            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    private int getTicketRetrievalRate(String eventName) {
        VendorEventConfigDTO vendorEventConfigDTO = vendorEventConfigService.getVendorEventConfigByEventName(eventName);
        return vendorEventConfigDTO.getCustomerRetrievalRate();
    }
}
