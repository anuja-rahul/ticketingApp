package org.example.ticketingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulate")
@RequiredArgsConstructor
@CrossOrigin
public class SimulateController {

    @Operation(summary = "simulation endpoint")
    @GetMapping("/start/{users}")
    public String simulateOperations(@PathVariable int users) {
        System.out.println("\nHello from the simulation endpoint: " + users + "\n");
        return "Hello from the simulation endpoint.";
    }
}