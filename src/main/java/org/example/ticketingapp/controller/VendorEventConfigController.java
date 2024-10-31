package org.example.ticketingapp.controller;


import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.TicketDTO;
import org.example.ticketingapp.dto.VendorEventConfigDTO;
import org.example.ticketingapp.dto.VendorEventConfigDTOIn;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.VendorEventConfigMapper;
import org.example.ticketingapp.repository.UserRepository;
import org.example.ticketingapp.service.TicketService;
import org.example.ticketingapp.service.VendorEventConfigService;
import org.springframework.dao.DataIntegrityViolationException;
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
    private TicketService ticketService;
    private final UserRepository repository;
    private final JwtService jwtService;

    @Operation(summary = "Returns all the VendorEventConfigs created by the vendor email")
    @GetMapping("/event")
    public ResponseEntity<List<VendorEventConfigDTO>> getConfigsByEmail(@RequestHeader("Authorization") String token) {

        try {
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
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 29:50
    @Operation(summary = "Create a new VendorEventConfig, only if logged in as a vendor")
    @PostMapping("/event")
    public ResponseEntity<VendorEventConfigDTO> createConfig(
            @RequestHeader("Authorization") String token,
            @RequestBody VendorEventConfigDTOIn vendorEventConfigDTOIn) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        try {
            if ("vendor".equalsIgnoreCase(user.getRole().name())) {
                VendorEventConfigDTO savedVendorEventConfig = vendorEventConfigService
                        .createVendorEventConfig(VendorEventConfigMapper
                                .mapFromInputSchema(vendorEventConfigDTOIn, email));

                TicketDTO newTicketDto = new TicketDTO(
                        savedVendorEventConfig.getEventName(),
                        savedVendorEventConfig.getTotalTickets(),
                        VendorEventConfigMapper.mapToVendorEventConfig(savedVendorEventConfig));

                ticketService.createTicket(newTicketDto);

                return new ResponseEntity<>(savedVendorEventConfig, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (DataIntegrityViolationException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @Operation(summary = "Create a new default VendorEventConfig, still working on this")
    @PostMapping("/event/default")
    public ResponseEntity<VendorEventConfigDTO> createDefaultConfig() {
        // TODO: implement reading from local json file and applying default values (Core java CLI)
        return null;
    }


}
