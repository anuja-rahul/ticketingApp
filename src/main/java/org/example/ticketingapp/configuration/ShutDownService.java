package org.example.ticketingapp.configuration;

import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
public class ShutDownService {

    private ThreadPoolTaskExecutor customTaskExecutor;
    private ThreadPoolTaskExecutor ticketExecutor;
    private ThreadPoolTaskExecutor vendorExecutor;
    private ThreadPoolTaskExecutor customerExecutor;

    @PreDestroy
    public void onDestroy() {
//        System.out.println("\nShutDownService is destroying ThreadPool Beans\n");
        shutDownExecutorService(customerExecutor, "Customer Executor");
        shutDownExecutorService(ticketExecutor, "Ticket Executor");
        shutDownExecutorService(vendorExecutor, "Vendor Executor");
        shutDownExecutorService(customTaskExecutor, "Custom Task Executor");
    }

    private void shutDownExecutorService(ThreadPoolTaskExecutor executorService, String executorName) {
        executorService.shutdown();
        try {
            System.out.println(executorName + ": waiting for threads to terminate");
            if (!executorService.getThreadPoolExecutor().awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.getThreadPoolExecutor().shutdownNow();

                if (!executorService.getThreadPoolExecutor().awaitTermination(5, TimeUnit.SECONDS)) {
                    System.err.println(executorName + " did not terminate ! \n");
                }
            } else {
                System.out.println(executorName + " terminated successfully.\n");
            }
        } catch (InterruptedException e) {
            executorService.getThreadPoolExecutor().shutdownNow();
            Thread.currentThread().interrupt();
            System.err.println("\n" + executorName + " interrupted during shutdown.\n");
        }
    }
}
