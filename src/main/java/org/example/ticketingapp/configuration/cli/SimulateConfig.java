package org.example.ticketingapp.configuration.cli;

import java.util.Scanner;

public class SimulateConfig {

    private static SimulateConfig instance;
    private final Scanner sc = new Scanner(System.in);
    private boolean simulate = false;
    private int users = 0;
    private int cycles = 0;

    private SimulateConfig() {}

    public static synchronized SimulateConfig getInstance() {
        if (instance == null) {
            instance = new SimulateConfig();
        }
        return instance;
    }

    public boolean getSimulationCommand() {
        while (true) {
            System.out.println("\nWould you like to run a simulation? (yes/no):\n");
            String response = sc.nextLine().trim().toLowerCase();

            if ("yes".equals(response)) {
                simulate = true;
                users = awaitInteger("\nEnter the number of users to simulate:");
                cycles = awaitInteger("\nEnter the number of simulation cycles:");
                return simulate;
            } else if ("no".equals(response)) {
                System.out.println("\nSimulation terminated\n");
                return simulate;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.\n");
            }
        }
    }

    private int awaitInteger(String message) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                if (validateInput(value)) {
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

    private boolean validateInput(int value) {
        return value > 0;
    }

    public boolean isSimulate() {
        return simulate;
    }

    public int getUsers() {
        return users;
    }

    public int getCycles() {
        return cycles;
    }
}
