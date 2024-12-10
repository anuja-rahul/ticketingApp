package org.example.ticketingapp;

import org.example.ticketingapp.configuration.cli.*;
import org.example.ticketingapp.controller.SimulateController;
import org.example.ticketingapp.controller.SystemController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@EnableAsync
public class TicketingAppApplication{

    public static void main(String[] args){
        try {
            boolean systemContinue = startup();
            if (systemContinue) {
                ConfigurableApplicationContext app = SpringApplication.run(TicketingAppApplication.class, args);
                simulate(app);
                finish(app);
            }

        } catch (IOException e) {
            System.err.println("Error reading from CLI: " + e.getMessage());
            System.exit(1);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error simulating from CLI: " + e.getMessage());
        }
    }

    public static boolean startup() throws IOException {
        StartConfig startConfig = StartConfig.getInstance();
        if (startConfig.awaitStartup()) {
            CliConfig.readFromCli();
            return true;
        }
        return false;
    }

    public static void simulate(ConfigurableApplicationContext app) throws InterruptedException, IOException, ExecutionException {
        SimulateConfig simulateConfig = SimulateConfig.getInstance();
        boolean access = simulateConfig.getSimulationCommand();
        if (access) {
            final int retrievalRate = CliVendorEventConfig.readFromJson().getCustomerRetrievalRate();
            SimulateController simulateController = app.getBean(SimulateController.class);
            Thread.sleep(2500);
            simulateController.simulateOperations(simulateConfig.getUsers(), retrievalRate, simulateConfig.getCycles());
        }
    }

    public static void finish(ConfigurableApplicationContext app) throws InterruptedException, IOException, ExecutionException {
        ExitConfig exitConfig = ExitConfig.getInstance();
        if (exitConfig.awaitTerminationCommand()) {
            SystemController nukeEndpoint = app.getBean(SystemController.class);
            System.out.println(nukeEndpoint.nukeTheWholeSystemFromCLI());
        }
    }

}
