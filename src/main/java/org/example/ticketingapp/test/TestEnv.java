package org.example.ticketingapp.test;

import org.example.ticketingapp.logger.MethodLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestEnv implements CommandLineRunner {
    Logger log = LoggerFactory.getLogger(TestEnv.class);

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @MethodLogger
    @Override
    public void run(String... args) throws Exception {
        log.info("Datasource URL: {}", datasourceUrl);
        log.info("Datasource Username: {}", datasourceUsername.replaceAll(".", "*"));
        log.info("Datasource Password: {}", datasourcePassword.replaceAll(".", "*"));
    }
}
