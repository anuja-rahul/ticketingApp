package org.example.ticketingapp.controller;

import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.CustomerDTO;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {
    private final JwtService jwtService;
    private CustomerService customerService;

    /**
     * Get the user data if a valid token is included in the request header
     */
    @Operation(summary = "Get the user profile information, if logged in as the user")
    @GetMapping
    public ResponseEntity<CustomerDTO> getCustomer(
            @RequestHeader("Authorization") String token){

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        try {

            Claims claims = jwtService.extractAllClaims(token);
            String email = claims.getSubject();
            return ResponseEntity.ok(customerService.getCustomerByEmail(email).get());

        } catch (ExecutionException | InterruptedException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
