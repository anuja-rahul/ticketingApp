package org.example.ticketingapp.controller;


import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.repository.UserRepository;
import org.example.ticketingapp.service.VendorEventConfigService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/config")
public class VendorEventConfigController {

    private VendorEventConfigService vendorEventConfigService;
    private final UserRepository repository;
    private final JwtService jwtService;

    @GetMapping("/event")
    public ResponseEntity<List<VendorEventConfigDTO>> getConfigsByEmail(@RequestHeader("Authorization") String token) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();

        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if ("vendor".equalsIgnoreCase(user.getRole().name())) {
            List<VendorEventConfigDTO> vendorEventConfigs = vendorEventConfigService.getAllVendorEventConfigsByEmail(email);
            return ResponseEntity.ok(vendorEventConfigs);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}
