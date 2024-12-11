package org.example.ticketingapp.controller;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Default controller class for handling general requests.
 * This class provides endpoints for testing the API status.
 * The class is annotated with {@link RestController} to indicate that it is a RESTful web service controller.
 * It is also annotated with {@link CrossOrigin} to allow cross-origin requests.
 * The base URL for all endpoints in this class is "/api".
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
@OpenAPIDefinition(info = @Info(title = "TicketingAPI", version = "1.0",
        description = "Dynamic ticketing application restful API"))
public class DefaultController {

    /**
     * Public endpoint available for testing the API status.
     *
     * @return a string message indicating the API status
     */
    @Operation(summary = "Public endpoint available for testing the api status")
    @GetMapping("/test")
    public String hello() {
        return "Hello from a public endpoint.";
    }

    /**
     * Handle OPTIONS requests for the /test endpoint.
     *
     * @return a {@link ResponseEntity} indicating the result of the operation
     */
    @RequestMapping(value = "/test", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().build();
    }
}
