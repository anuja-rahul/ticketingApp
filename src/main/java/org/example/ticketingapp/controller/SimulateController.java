package org.example.ticketingapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.service.SimulateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Controller class for handling simulation-related requests.
 * This class provides endpoints for simulating operations.
 * The class is annotated with {@link RestController} to indicate that it is a RESTful web service controller.
 * It is also annotated with {@link CrossOrigin} to allow cross-origin requests.
 * The base URL for all endpoints in this class is "/api/simulate".
 */
@RestController
@RequestMapping("/api/simulate")
@AllArgsConstructor
@CrossOrigin
public class SimulateController {

    private SimulateService simulateService;

    /**
     * Simulation endpoint for starting the simulation with specified parameters.
     *
     * @param users the number of users to simulate
     * @param rate the ticketRetrievalRate
     * @param cycles the number of cycles to run the simulation
     * @return a string message indicating the result of the simulation
     */
    @Operation(summary = "simulation endpoint")
    @GetMapping("/start/{users}/{rate}/{cycles}")
    public String simulateOperations(@PathVariable int users, @PathVariable int rate, @PathVariable int cycles) {
        try {
            System.out.println("\nHello from the simulation endpoint: simulating " + users + " users" + "\n");
            simulateService.simulate(users, rate, cycles);
            return "Hello from the simulation endpoint.";
        } catch (IOException | ExecutionException | InterruptedException e) {
            return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        }
    }
}