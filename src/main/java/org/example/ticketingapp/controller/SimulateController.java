package org.example.ticketingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.service.SimulateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulate")
@AllArgsConstructor
@CrossOrigin
public class SimulateController {

    private SimulateService simulateService;

    @Operation(summary = "simulation endpoint")
    @GetMapping("/start/{users}")
    public String simulateOperations(@PathVariable int users) {
        System.out.println("\nHello from the simulation endpoint: " + users + "\n");
        simulateService.simulate(users);
        return "Hello from the simulation endpoint.";
    }
}