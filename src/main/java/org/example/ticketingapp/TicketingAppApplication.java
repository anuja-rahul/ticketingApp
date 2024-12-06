package org.example.ticketingapp;

import org.example.ticketingapp.configuration.cli.CliConfig;
import org.example.ticketingapp.controller.SimulateController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;

@SpringBootApplication
@EnableAsync
public class TicketingAppApplication{

    public static void main(String[] args){
        try {
            startup();
            ConfigurableApplicationContext app = SpringApplication.run(TicketingAppApplication.class, args);
            simulate(app);
            finish();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error reading from CLI: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void startup() throws IOException {
        CliConfig.readFromCli();
        // start
    }

    public static void finish() {
        // stop
    }

    public static void simulate(ConfigurableApplicationContext app) throws InterruptedException {
        SimulateController simulateController = app.getBean(SimulateController.class);
        Thread.sleep(2500);
        if (true) {
            simulateController.simulateOperations(5);
        }
    }

}
