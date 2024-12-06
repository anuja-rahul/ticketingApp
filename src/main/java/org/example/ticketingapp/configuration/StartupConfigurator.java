package org.example.ticketingapp.configuration;

import lombok.RequiredArgsConstructor;
import org.example.ticketingapp.service.StatService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

@Configuration
@RequiredArgsConstructor
public class StartupConfigurator implements ApplicationRunner {
    private final StatService statService;

    @Override
    public void run(ApplicationArguments args) throws ExecutionException, InterruptedException {
        System.out.println("\n" + LocalDate.now() + ": Setting up the record history...\n");
        statService.updateHistoryRecord();
    }
}
