package org.example.ticketingapp.configuration.cli;

import java.util.Scanner;

public class ExitConfig {

    private static ExitConfig instance;

    private ExitConfig() {}

    public static ExitConfig getInstance() {
        if (instance == null) {
            instance = new ExitConfig();
        }
        return instance;
    }

    public boolean awaitTerminationCommand() {
        Scanner sc = new Scanner(System.in);
        String userCMD = "";

        System.out.println("\nEnter 'exit()' to shutdown the system:\n");

        while (!userCMD.equals("exit()")) {
            userCMD = sc.nextLine();
            if (!userCMD.equals("exit()")) {
                System.out.println("Invalid command. Please enter 'exit()' to shutdown the system.\n");
            }
        }

        sc.close();
        return true;
    }
}
