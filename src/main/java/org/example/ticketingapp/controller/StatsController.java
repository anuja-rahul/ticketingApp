package org.example.ticketingapp.controller;


import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.CustomerTicketRecordDTO;
import org.example.ticketingapp.dto.RecordDTO;
import org.example.ticketingapp.dto.SalesDTO;
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

/**
 * Controller class for handling statistics-related requests.
 * This class provides endpoints for retrieving various statistics.
 * It uses {@link StatService} to perform operations related to statistics.
 * The class is annotated with {@link RestController} to indicate that it is a REST ful web service controller.
 * It is also annotated with {@link CrossOrigin} to allow cross-origin requests.
 * The base URL for all endpoints in this class is "/api/stats".
 */
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/stats")
public class StatsController {
    private StatService statService;
    private final JwtService jwtService;
    private final UserRepository repository;

    /**
     * Returns all the current ticket pool stats.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the total ticket pool stats
     */
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

    /**
     * Returns all the history records saved by the server.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the list of history records
     */
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

    /**
     * Returns all the tickets sold by eventName summed up based on customerTicket records.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the list of customer ticket records
     */
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

    /**
     * Returns all the sales records saved by the server sorted by date.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the list of sales records
     */
    @Operation(summary = "Returns all the sales records saved by the server sorted by date")
    @GetMapping("/sales")
    public ResponseEntity<List<SalesDTO>> getAllSalesRecords(
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
                List<SalesDTO> salesRecord = statService.getAllSalesRecords().get();
                return ResponseEntity.ok(salesRecord);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
