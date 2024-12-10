package org.example.ticketingapp.configuration.cli;

import java.util.Scanner;

public class StartConfig {

    private static StartConfig instance;
    private final Scanner sc = new Scanner(System.in);

    private StartConfig() {}

    public static synchronized StartConfig getInstance() {
        if (instance == null) {
            instance = new StartConfig();
        }
        return instance;
    }

    public boolean awaitStartup() {
        while (true) {
            System.out.println("\nEnter 'start()' to begin or 'exit()' to quit:\n");
            String response = sc.nextLine().trim().toLowerCase();

            if ("start()".equals(response)) {
                return true;
            } else if ("exit()".equals(response)) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'start()' to begin or 'exit()' to quit.");
            }
        }
    }
}
