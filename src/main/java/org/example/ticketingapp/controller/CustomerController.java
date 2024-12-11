package org.example.ticketingapp.controller;

import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.CustomerDtoOut;
import org.example.ticketingapp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;


/**
 * Controller class for handling customer-related requests.
 * This class provides endpoints for retrieving customer information.
 * It uses {@link CustomerService} to perform operations related to customers.
 * The class is annotated with {@link RestController} to indicate that it is a RESTful web service controller.
 * It is also annotated with {@link CrossOrigin} to allow cross-origin requests.
 * The base URL for all endpoints in this class is "/api/customer".
 */
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {
    private final JwtService jwtService;
    private CustomerService customerService;

    /**
     * Get the user data if a valid token is included in the request header.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the customer data if the token is valid, or an error response otherwise
     */
    @Operation(summary = "Get the user profile information, if logged in as the user")
    @GetMapping
    public ResponseEntity<CustomerDtoOut> getCustomer(
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
