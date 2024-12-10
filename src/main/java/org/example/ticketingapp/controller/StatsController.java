package org.example.ticketingapp.controller;


import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.CustomerTicketRecordDTO;
import org.example.ticketingapp.dto.RecordDTO;
import org.example.ticketingapp.dto.TotalTicketsTimeDtoOut;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.repository.UserRepository;
import org.example.ticketingapp.service.StatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/stats")
public class StatsController {
    private StatService statService;
    private final JwtService jwtService;
    private final UserRepository repository;

    @Operation(summary = "Returns all the current ticket pool stats")
    @GetMapping("/ticketPool")
    public ResponseEntity<TotalTicketsTimeDtoOut> getTotalTicketPoolStats(
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

            if ("admin".equalsIgnoreCase(user.getRole().name())) {
                CompletableFuture<TotalTicketsTimeDtoOut> result = statService.getTicketPoolStats();
                return ResponseEntity.ok(result.get());
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        } catch (ExecutionException | InterruptedException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Returns all the history records saved by the server")
    @GetMapping("/history")
    public ResponseEntity<List<RecordDTO>> getHistoryRecords(
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

            if ("admin".equalsIgnoreCase(user.getRole().name())) {
                List<RecordDTO> historyRecord = statService.getHistoryRecords().get();
                return ResponseEntity.ok(historyRecord);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Returns all the tickets sold by eventName summed up based on customerTicket records")
    @GetMapping("/sold")
    public ResponseEntity<List<CustomerTicketRecordDTO>> getCustomerTicketRecords(
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

            if ("admin".equalsIgnoreCase(user.getRole().name())) {
                List<CustomerTicketRecordDTO> customerStats = statService.getCustomerTicketPoolStats().get();
                return ResponseEntity.ok(customerStats);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // TODO: use the sales data
}
