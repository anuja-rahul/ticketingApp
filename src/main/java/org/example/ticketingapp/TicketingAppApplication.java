package org.example.ticketingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketingAppApplication {
    public static void main(String[] args) {



        SpringApplication.run(TicketingAppApplication.class, args);
        System.out.println("\nThis is before launching my spring application\n");
        System.out.println("\nHello\n");
    }

}
