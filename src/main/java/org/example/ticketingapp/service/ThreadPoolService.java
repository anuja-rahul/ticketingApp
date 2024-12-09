package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.ThreadDtoOut;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public interface ThreadPoolService {
    CompletableFuture<List<ThreadDtoOut>> getCurrentThreadStatus() throws ExecutionException, InterruptedException;
    CompletableFuture<List<ThreadDtoOut>> getAllThreadRecords() throws ExecutionException, InterruptedException;
    CompletableFuture<ArrayList<Integer>> getStatus(ThreadPoolTaskExecutor executor);

}
