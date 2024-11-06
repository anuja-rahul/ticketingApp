package org.example.ticketingapp.configuration.cli;

import java.io.IOException;
import java.util.Scanner;

import static org.example.ticketingapp.utility.BaseUtils.divideAndCeil;

/**
 * Singleton class to read configuration from CLI
 * This class was made singleton to avoid multiple instances of the configuration at the startup due to spring boot
 * autoconfiguration and dependency injection.
 */
public class CliConfig {

    private static CliConfig instance;
    private final Scanner sc = new Scanner(System.in);
    public static boolean isConfigured = false;

    // Private constructor to prevent instantiation
    private CliConfig() {}

    // Public method to provide access to the instance
    public static synchronized CliConfig getInstance() {
        if (instance == null) {
            instance = new CliConfig();
        }
        return instance;
    }

    public static void readFromCli() throws IOException {
        CliConfig config = CliConfig.getInstance();

        if (isConfigured) {
            System.out.println("Configuration already read, skipping...");
            return;
        }

        int maxTicketCapacity = config.takeInputs("\nEnter max ticket capacity:");
        int totalTickets = config.takeInputs(
                "\nEnter total tickets:",
                maxTicketCapacity,
                "total tickets must be less than max ticket capacity.");
        int ticketReleaseRate = config.takeInputs("\nEnter ticket release rate:");
        int customerRetrievalRate = config.takeInputs(
                "\nEnter customer retrieval rate:",
                ticketReleaseRate,
                "customer retrieval rate must be less than ticket release rate.");

        CliVendorEventConfig cliVendorEventConfig = new CliVendorEventConfig(
                totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);

        // Writing to config.json file at the root of the application
        cliVendorEventConfig.writeToJson();

        System.out.println("\nConfiguration:\n");
        System.out.println("Total Tickets: " + cliVendorEventConfig.getTotalTickets());
        System.out.println("Ticket Release Rate: " + cliVendorEventConfig.getTicketReleaseRate());
        System.out.println("Customer Retrieval Rate: " + cliVendorEventConfig.getCustomerRetrievalRate());
        System.out.println("Max Ticket Capacity: " + cliVendorEventConfig.getMaxTicketCapacity());

        CliVendorEventConfig tempCliVendorEventConfig = CliVendorEventConfig.readFromJson();
        int basePoolSize = divideAndCeil(
                tempCliVendorEventConfig.getTicketReleaseRate(),
                tempCliVendorEventConfig.getCustomerRetrievalRate());
        int maxQueueSize = divideAndCeil(
                tempCliVendorEventConfig.getMaxTicketCapacity(), basePoolSize);

        System.out.println("\nbaseThreadPoolSize: " + basePoolSize);
        System.out.println("maxTaskQueueSize: " + maxQueueSize + "\n");

        isConfigured = true;
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

    // Overloading for a specific case (customerRetrievalRate, totalTickets)
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
