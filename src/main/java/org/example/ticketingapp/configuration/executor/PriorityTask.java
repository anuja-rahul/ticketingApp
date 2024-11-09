package org.example.ticketingapp.configuration.executor;

import lombok.Getter;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class PriorityTask<V> implements Runnable {
    @Getter
    private final int priority;
    private final Callable<V> task;
    @Getter
    private final CompletableFuture<V> future;

    public PriorityTask(int priority, Callable<V> task) {
        this.priority = priority;
        this.task = task;
        this.future = new CompletableFuture<>();
    }

    @Override
    public void run() {
        try {
            V result = task.call();
            future.complete(result);
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
    }
}
