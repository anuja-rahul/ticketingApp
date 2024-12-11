package org.example.ticketingapp.controller;


import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.ThreadDtoOut;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.repository.UserRepository;
import org.example.ticketingapp.service.ThreadPoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling thread-related requests.
 * This class provides endpoints for managing thread pools.
 * It uses {@link ThreadPoolService} to perform operations related to thread pools.
 * The class is annotated with {@link RestController} to indicate that it is a RESTful web service controller.
 * It is also annotated with {@link CrossOrigin} to allow cross-origin requests.
 * The base URL for all endpoints in this class is "/api/thread".
 */
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/thread")
public class ThreadController {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final ThreadPoolService threadPoolService;

    /**
     * Retrieve the current status of all thread pools.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the current status of all thread pools
     */
    @Operation(summary = "Retrieve the current status of all thread pools")
    @GetMapping("/current")
    public ResponseEntity<List<ThreadDtoOut>> getCurrentThreadStatus(
            @RequestHeader("Authorization") String token
    ) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Claims claims = jwtService.extractAllClaims(token);
            String email = claims.getSubject();
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            if ("admin".equalsIgnoreCase(user.getRole().name())) {
                return ResponseEntity.ok(threadPoolService.getCurrentThreadStatus().get());
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    /**
     * Retrieve all thread records upto last 60 latest records.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the list of all thread records
     */
    @Operation(summary = "Retrieve all thread records upto last 60 latest records")
    @GetMapping("/all")
    public ResponseEntity<List<ThreadDtoOut>> getAllThreadRecords(
            @RequestHeader("Authorization") String token
    ) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Claims claims = jwtService.extractAllClaims(token);
            String email = claims.getSubject();
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            if ("admin".equalsIgnoreCase(user.getRole().name())) {
                return ResponseEntity.ok(threadPoolService.getAllThreadRecords().get());
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Retrieve all thread records sorted by thread name.
     *
     * @param token the JWT token included in the request header
     * @param type the type by which the thread records should be sorted
     * @return a {@link ResponseEntity} containing the list of sorted thread records
     */
    @Operation(summary = "Retrieve all thread records sorted by thread name")
    @GetMapping("/sort/{type}")
    public ResponseEntity<List<ThreadDtoOut>> getAllThreadRecordsByThreadName(
            @RequestHeader("Authorization") String token,
            @PathVariable String type
    ) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Claims claims = jwtService.extractAllClaims(token);
            String email = claims.getSubject();
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            if ("admin".equalsIgnoreCase(user.getRole().name())) {
                return ResponseEntity.ok(threadPoolService.getAllThreadRecordsByType(type).get());
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
