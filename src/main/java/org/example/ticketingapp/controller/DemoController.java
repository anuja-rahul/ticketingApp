package org.example.ticketingapp.controller;

import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Demo controller class for handling demo-related requests.
 * This class provides endpoints for testing the API JWT authentication services.
 * The class is annotated with {@link RestController} to indicate that it is a RESTful web service controller.
 * It is also annotated with {@link CrossOrigin} to allow cross-origin requests.
 * The base URL for all endpoints in this class is "/api/demo".
 */
@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
@CrossOrigin
public class DemoController {
    private final JwtService jwtService;
    private final UserRepository repository;

    /**
     * Secure endpoint available for testing the API JWT authentication services.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing a string message indicating the result of the operation
     */
    @Operation(summary = "Secure endpoint available for testing the api JWT auth services")
    @GetMapping
    public ResponseEntity<String> hello(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();

        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));


        return ResponseEntity.ok("Hello [" + email + " " + user.getRole().name() + "] from a secured endpoint.");
    }
}
