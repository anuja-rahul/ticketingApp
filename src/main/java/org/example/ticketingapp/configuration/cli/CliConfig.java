package org.example.ticketingapp.configuration.cli;

import java.io.IOException;
import java.util.Scanner;

public class CliConfig {

    private final Scanner sc = new Scanner(System.in);

    public static void readFromCli() throws IOException {
        CliConfig config = new CliConfig();

        int maxTicketCapacity = config.takeInputs("Enter max ticket capacity:");
        int totalTickets = config.takeInputs(
                "Enter total tickets:",
                maxTicketCapacity,
                "total tickets must be less than max ticket capacity.");
        int ticketReleaseRate = config.takeInputs("Enter ticket release rate:");
        int customerRetrievalRate = config.takeInputs(
                "Enter customer retrieval rate:",
                ticketReleaseRate,
                "customer retrieval rate must be less than ticket release rate.");

        CliVendorEventConfig cliVendorEventConfig = new CliVendorEventConfig(
                totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);

        System.out.println("Configuration:");
        System.out.println("Total Tickets: " + cliVendorEventConfig.getTotalTickets());
        System.out.println("Ticket Release Rate: " + cliVendorEventConfig.getTicketReleaseRate());
        System.out.println("Customer Retrieval Rate: " + cliVendorEventConfig.getCustomerRetrievalRate());
        System.out.println("Max Ticket Capacity: " + cliVendorEventConfig.getMaxTicketCapacity());

        // Writing to config.json file at the root of the application
        cliVendorEventConfig.writeToJson();
    }

    private int takeInputs(String message) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                if (validateInputs(value)) {
                    return value;
                } else {
                    System.out.println("Value must be greater than zero.");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                sc.next();
            }
        }
    }

    // overloading for a specific case (customerRetrievalRate, totalTickets)
    private int takeInputs(String message, int bigValue, String errorMessage) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                if (validateInputs(value, bigValue)) {
                    return value;
                } else {
                    System.out.println(errorMessage);
                }
            } else {
                System.out.println("Please enter a valid integer.");
                sc.next();
            }
        }
    }

    private boolean validateInputs(int value) {
        return value > 0;
    }

    private boolean validateInputs(int value, int bigValue) {
        return value > 0 && value <= bigValue;
    }
}
