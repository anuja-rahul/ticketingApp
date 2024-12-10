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

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
@CrossOrigin
public class DemoController {
    private final JwtService jwtService;
    private final UserRepository repository;

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
