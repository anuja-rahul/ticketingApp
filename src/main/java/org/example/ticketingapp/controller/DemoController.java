package org.example.ticketingapp.controller;

import org.example.ticketingapp.configuration.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    private final JwtService jwtService;

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
