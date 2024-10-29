package org.example.ticketingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.ticketingapp.configuration.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
@CrossOrigin
public class DemoController {
    private final JwtService jwtService;

    @Operation(summary = "Secure endpoint available for testing the api JWT auth services")
    @GetMapping
    public ResponseEntity<String> hello(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();
        return ResponseEntity.ok("Hello [" + email + "] from a secured endpoint.");
    }
}
