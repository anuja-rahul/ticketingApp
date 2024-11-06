package org.example.ticketingapp;

import org.example.ticketingapp.configuration.cli.CliConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;

@SpringBootApplication
@EnableAsync
public class TicketingAppApplication{

    public static void main(String[] args){
        try {
            config();
            SpringApplication.run(TicketingAppApplication.class, args);
        } catch (IOException e) {
            System.err.println("Error reading from CLI: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void config() throws IOException {
        CliConfig.readFromCli();
    }

}
