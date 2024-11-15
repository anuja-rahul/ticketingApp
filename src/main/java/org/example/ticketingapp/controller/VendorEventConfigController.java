package org.example.ticketingapp.controller;


import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.dto.VendorEventConfigDTOIn;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.ResourceCapacityException;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.repository.UserRepository;
import org.example.ticketingapp.service.VendorEventConfigService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/config")
public class VendorEventConfigController {

    private VendorEventConfigService vendorEventConfigService;
    private final UserRepository repository;
    private final JwtService jwtService;

    @Operation(summary = "Returns all the VendorEventConfigs created by the vendor email")
    @GetMapping("/event")
    public ResponseEntity<List<VendorEventConfigDTO>> getConfigsByEmail(
            @RequestHeader("Authorization") String token
    ) {

        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Claims claims = jwtService.extractAllClaims(token);
            String email = claims.getSubject();
            User user = repository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            if ("vendor".equalsIgnoreCase(user.getRole().name())) {
                CompletableFuture<List<VendorEventConfigDTO>> vendorEventConfigs = vendorEventConfigService.getAllVendorEventConfigsByEmail(email);
                return ResponseEntity.ok(vendorEventConfigs.get());
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 29:50
    @Operation(summary = "Create a new VendorEventConfig, only if logged in as a vendor")
    @PostMapping("/event")
    public ResponseEntity<VendorEventConfigDTO> createConfig(
            @RequestHeader("Authorization") String token,
            @Validated @RequestBody VendorEventConfigDTOIn vendorEventConfigDTOIn) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        try {
            if ("vendor".equalsIgnoreCase(user.getRole().name())) {
                CompletableFuture<VendorEventConfigDTO> savedVendorEventConfig = vendorEventConfigService
                        .createVendorEventConfig(vendorEventConfigDTOIn, email);
                return new ResponseEntity<>(savedVendorEventConfig.get(), HttpStatus.CREATED);

            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (DataIntegrityViolationException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (IOException | InterruptedException | ExecutionException IoEx) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Operation(summary = "Updates the VendorEventConfig totalTicket parameter, " +
            "only if logged in as a vendor and it already exists")
    @PutMapping("/event/{eventName}/{totalTickets}")
    public ResponseEntity<VendorEventConfigDTO> updateVendorEventConfig(
            @RequestHeader("Authorization") String token,
            @PathVariable String eventName,
            @PathVariable int totalTickets
    ) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        try {
            if ("vendor".equalsIgnoreCase(user.getRole().name())) {
                boolean configExist = vendorEventConfigService.existsByEventName(eventName);
                if (configExist) {
                    CompletableFuture<VendorEventConfigDTO> updatedVendorEventConfig = vendorEventConfigService
                            .updateTotalTickets(eventName, totalTickets);


                    return new ResponseEntity<>(updatedVendorEventConfig.get(), HttpStatus.OK);
                }
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        } catch (ResourceNotFoundException resEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ResourceCapacityException resCapEx) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (IOException | ExecutionException | InterruptedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Deletes a VendorEventConfig by event name, only if logged in as a vendor")
    @DeleteMapping("/event/{eventName}")
    public ResponseEntity<Object> deleteVendorEventConfig(
            @RequestHeader("Authorization") String token,
            @PathVariable String eventName
    ) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            try {
                if ("vendor".equalsIgnoreCase(user.getRole().name())) {
                    vendorEventConfigService.deleteVendorEventConfig(eventName, email);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            } catch (ResourceNotFoundException resEx) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @Operation(summary = "Get all VendorEventConfigs if logged in as a customer/admin")
    @GetMapping("/all")
    public ResponseEntity<List<VendorEventConfigDTO>> getAllVendorEventConfigs(
            @RequestHeader("Authorization") String token
    ) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        try {
            if ("customer".equalsIgnoreCase(user.getRole().name()) || "admin".equalsIgnoreCase(user.getRole().name())) {

                // logic to return all vendor event configs
                CompletableFuture<List<VendorEventConfigDTO>> allVendorEventConfigs = vendorEventConfigService
                        .getAllVendorEventConfigs();

                return new ResponseEntity<>(allVendorEventConfigs.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (ResourceNotFoundException resEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ExecutionException | InterruptedException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
