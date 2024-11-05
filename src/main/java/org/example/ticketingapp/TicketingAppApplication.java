package org.example.ticketingapp;

import org.example.ticketingapp.configuration.cli.CliConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TicketingAppApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(TicketingAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CliConfig.readFromCli();
    }
}
