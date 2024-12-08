package org.example.ticketingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.service.SimulateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/simulate")
@AllArgsConstructor
@CrossOrigin
public class SimulateController {

    private SimulateService simulateService;

    @Operation(summary = "simulation endpoint")
    @GetMapping("/start/{users}")
    public String simulateOperations(@PathVariable int users) throws IOException, ExecutionException, InterruptedException {
        try {
            System.out.println("\nHello from the simulation endpoint: simulating " + users + " users" + "\n");
            simulateService.simulate(users);
            return "Hello from the simulation endpoint.";
        } catch (IOException | ExecutionException | InterruptedException e) {
            return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        }
    }
}