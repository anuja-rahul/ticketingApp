package org.example.ticketingapp.controller;

import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.configuration.ShutDownService;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.logger.MethodLogger;
import org.example.ticketingapp.repository.UserRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling system-related requests.
 * This class provides endpoints for system operations such as shutdown.
 * The class is annotated with {@link RestController} to indicate that it is a RESTful web service controller.
 * It is also annotated with {@link CrossOrigin} to allow cross-origin requests.
 * The base URL for all endpoints in this class is "/api/system".
 */
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/system")
public class SystemController {

    private final JwtService jwtService;
    private final UserRepository repository;

    private ConfigurableApplicationContext context;
    private ShutDownService shutDownService;

    /**
     * Safely close off all thread pools and shuts down the system.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing a string message indicating the result of the operation
     */
    @Operation(summary = "Safely close off all thread pools and shuts down the system")
    @GetMapping("/nuke")
    @MethodLogger
    public ResponseEntity<String> nukeTheWholeSystem(
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
                System.out.println("\nSystem Shutdown was authorized by admin: " + user.getName() + "\n");
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    shutDownService.onDestroy();
                    context.close();
                    System.exit(0);
                }).start();
                return ResponseEntity.ok("System is being shutdown");
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Failed Shutting down the system", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Safely close off all thread pools and shuts down the system from the command line interface.
     *
     * @return a string message indicating the result of the operation
     */
    @MethodLogger
    public String nukeTheWholeSystemFromCLI() {
        try {
            System.out.println("\nSystem Shutdown was authorized by superuser\n");
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                shutDownService.onDestroy();
                context.close();
                System.exit(0);
            }).start();
            return "System is being shutdown";

        } catch (Exception e) {
            return (e.getMessage() + ": INTERNAL SERVER ERROR");
        }
    }
}
