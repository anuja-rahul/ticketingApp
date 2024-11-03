package org.example.ticketingapp.configuration.cli;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CliConfigWriter {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void writeConfig(CliVendorEventConfig config) throws IOException {
        String rootPath = new File("").getAbsolutePath();
        String filePath = rootPath + File.separator + "config.json";

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(config, writer);
        }

        System.out.println("Configuration written to " + filePath);
    }

    public static CliVendorEventConfig readConfig() throws IOException {
        String rootPath = new File("").getAbsolutePath();
        String filePath = rootPath + File.separator + "config.json";

        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, CliVendorEventConfig.class);
        }
    }
}
