package org.example.ticketingapp.configuration.executor;

import org.example.ticketingapp.configuration.cli.CliVendorEventConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.IOException;
import java.util.concurrent.Executor;

import static org.example.ticketingapp.utility.BaseUtils.divideAndCeil;

@Configuration
public class ThreadPoolConfig {

    private final CliVendorEventConfig cliVendorEventConfig = CliVendorEventConfig.readFromJson();
    private final int basePoolSize = divideAndCeil(
            cliVendorEventConfig.getTicketReleaseRate(),
            cliVendorEventConfig.getCustomerRetrievalRate());
    private final int maxQueueSize = divideAndCeil(
            cliVendorEventConfig.getMaxTicketCapacity(), basePoolSize);

    public ThreadPoolConfig() throws IOException {}

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(basePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(basePoolSize);
        threadPoolTaskExecutor.setQueueCapacity(maxQueueSize);
        threadPoolTaskExecutor.setThreadNamePrefix("TicketingApiTaskThread-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Bean(name = "ticketExecutor")
    public Executor ticketExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(basePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(basePoolSize);
        threadPoolTaskExecutor.setQueueCapacity(maxQueueSize);
        threadPoolTaskExecutor.setThreadNamePrefix("TicketingApiTicketThread-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Bean(name = "vendorExecutor")
    public Executor vendorExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(basePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(basePoolSize);
        threadPoolTaskExecutor.setQueueCapacity(maxQueueSize);
        threadPoolTaskExecutor.setThreadNamePrefix("TicketingApiVendorThread-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}