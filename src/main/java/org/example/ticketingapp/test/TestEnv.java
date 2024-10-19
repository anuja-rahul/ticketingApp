package org.example.ticketingapp.test;

import org.example.ticketingapp.logger.MethodLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestEnv implements CommandLineRunner {


    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @MethodLogger
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Datasource URL: " + datasourceUrl);
        System.out.println("Datasource Username: " + datasourceUsername.replaceAll(".", "*"));
        System.out.println("Datasource Password: " + datasourcePassword.replaceAll(".", "*"));
    }
}
