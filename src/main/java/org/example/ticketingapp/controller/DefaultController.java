package org.example.ticketingapp.controller;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
@OpenAPIDefinition(info = @Info(title = "TicketingAPI", version = "1.0",
        description = "Dynamic ticketing application restful API"))
public class DefaultController {

    @Operation(summary = "Public endpoint available for testing the api status")
    @GetMapping("/test")
    public String hello() {
        return "Hello from a public endpoint.";
    }
}
