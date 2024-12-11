package org.example.ticketingapp.configuration.executor;

import org.example.ticketingapp.configuration.cli.CliVendorEventConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.IOException;

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

    @Bean(name = "customTaskExecutor")
    public ThreadPoolTaskExecutor customTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(60);
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setQueueCapacity(400);
        threadPoolTaskExecutor.setThreadNamePrefix("TicketingApiTaskThread-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Bean(name = "ticketExecutor")
    public ThreadPoolTaskExecutor ticketExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor() {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                if (r instanceof PriorityTask) {
                    t.setPriority(((PriorityTask<?>) r).getPriority());
                }
            }
        };

        threadPoolTaskExecutor.setCorePoolSize(basePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(basePoolSize);
        threadPoolTaskExecutor.setQueueCapacity(maxQueueSize);
        threadPoolTaskExecutor.setThreadNamePrefix("TicketingApiTicketThread-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Bean(name = "vendorExecutor")
    public ThreadPoolTaskExecutor vendorExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(basePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(basePoolSize);
        threadPoolTaskExecutor.setQueueCapacity(maxQueueSize);
        threadPoolTaskExecutor.setThreadNamePrefix("TicketingApiVendorThread-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Bean(name = "customerExecutor")
    public ThreadPoolTaskExecutor customerExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(basePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(basePoolSize);
        threadPoolTaskExecutor.setQueueCapacity(maxQueueSize);
        threadPoolTaskExecutor.setThreadNamePrefix("TicketingApiCustomerThread-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    public int getActiveThreads(ThreadPoolTaskExecutor executor) {
        return executor.getActiveCount();
    }

    public int getTotalThreads(ThreadPoolTaskExecutor executor) {
        return executor.getThreadPoolExecutor().getMaximumPoolSize();
    }

    public int getIdleThreads(ThreadPoolTaskExecutor executor) {
        return getTotalThreads(executor) - getActiveThreads(executor);
    }
}
