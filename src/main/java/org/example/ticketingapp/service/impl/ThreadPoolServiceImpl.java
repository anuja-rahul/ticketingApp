package org.example.ticketingapp.service.impl;

//import jakarta.annotation.PostConstruct;
import org.example.ticketingapp.configuration.executor.ThreadPoolConfig;
import org.example.ticketingapp.dto.ThreadDtoOut;
import org.example.ticketingapp.entity.ThreadPool;
import org.example.ticketingapp.logger.MethodLogger;
import org.example.ticketingapp.mapper.ThreadPoolMapper;
import org.example.ticketingapp.repository.ThreadPoolRepository;
import org.example.ticketingapp.service.ThreadPoolService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

// PageRequest.of(0, 20)

@Service
public class ThreadPoolServiceImpl implements ThreadPoolService {

    private final ThreadPoolTaskExecutor taskExecutor;
    private final ThreadPoolTaskExecutor ticketExecutor;
    private final ThreadPoolTaskExecutor vendorExecutor;
    private final ThreadPoolTaskExecutor customerExecutor;
    private final ThreadPoolConfig threadPoolConfig;
    private final ThreadPoolRepository threadRepository;

    public ThreadPoolServiceImpl(
            @Qualifier("customTaskExecutor") ThreadPoolTaskExecutor taskExecutor,
            @Qualifier("ticketExecutor") ThreadPoolTaskExecutor ticketExecutor,
            @Qualifier("vendorExecutor") ThreadPoolTaskExecutor vendorExecutor,
            @Qualifier("customerExecutor") ThreadPoolTaskExecutor customerExecutor,
            ThreadPoolConfig threadPoolConfig, ThreadPoolRepository threadRepository) {
        this.taskExecutor = taskExecutor;
        this.ticketExecutor = ticketExecutor;
        this.vendorExecutor = vendorExecutor;
        this.customerExecutor = customerExecutor;
        this.threadPoolConfig = threadPoolConfig;
        this.threadRepository = threadRepository;
    }

//    @PostConstruct
//    public void init() {
//        // Submit test tasks
//        submitTestTasks(taskExecutor, "TaskExecutor");
//        submitTestTasks(ticketExecutor, "TicketExecutor");
//        submitTestTasks(vendorExecutor, "VendorExecutor");
//        submitTestTasks(customerExecutor, "CustomerExecutor");
//    }
//
//    private void submitTestTasks(ThreadPoolTaskExecutor executor, String executorName) {
//        for (int i = 0; i < 5; i++) {
//            executor.execute(() -> {
//                System.out.println("Executing task in " + executorName);
//                try {
//                    Thread.sleep(2000); // Simulate task
//                    System.out.println("Completed task in " + executorName);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            });
//        }
//    }

    @Async("customTaskExecutor")
    @MethodLogger
    public CompletableFuture<List<ThreadDtoOut>> getCurrentThreadStatus() throws ExecutionException, InterruptedException {
        ArrayList<Integer> taskList = getStatus(taskExecutor).get();
        ArrayList<Integer> ticketList = getStatus(ticketExecutor).get();
        ArrayList<Integer> vendorList = getStatus(vendorExecutor).get();
        ArrayList<Integer> customerList = getStatus(customerExecutor).get();

        List<ThreadDtoOut> threadDtoOutList = new ArrayList<>();
        LocalDateTime baseTime = LocalDateTime.now();

        ThreadDtoOut task = new ThreadDtoOut(
                baseTime.plusNanos(1),
                "taskExecutor",
                taskList.get(0),
                taskList.get(1),
                taskList.get(2)
        );
        ThreadDtoOut ticket = new ThreadDtoOut(
                baseTime.plusNanos(2),
                "ticketExecutor",
                ticketList.get(0),
                ticketList.get(1),
                ticketList.get(2)
        );
        ThreadDtoOut vendor = new ThreadDtoOut(
                baseTime.plusNanos(3),
                "vendorExecutor",
                vendorList.get(0),
                vendorList.get(1),
                vendorList.get(2)
        );
        ThreadDtoOut customer = new ThreadDtoOut(
                baseTime.plusNanos(4),
                "customerExecutor",
                customerList.get(0),
                customerList.get(1),
                customerList.get(2)
        );

        // TODO: FIX THIS
        threadDtoOutList.add(task);
        threadRepository.save(ThreadPoolMapper.mapToThreadPool(task));
        threadDtoOutList.add(ticket);
        threadRepository.save(ThreadPoolMapper.mapToThreadPool(ticket));
        threadDtoOutList.add(vendor);
        threadRepository.save(ThreadPoolMapper.mapToThreadPool(vendor));
        threadDtoOutList.add(customer);
        threadRepository.save(ThreadPoolMapper.mapToThreadPool(customer));

//        for (ThreadDtoOut threadDtoOut : threadDtoOutList) {
//            System.out.println(threadDtoOut + "\n");
//            ThreadPool mappedThreadPool = ThreadPoolMapper.mapToThreadPool(threadDtoOut);
//            threadRepository.save(mappedThreadPool);
//        };

        return CompletableFuture.completedFuture(threadDtoOutList);
    }

    @Async("customTaskExecutor")
    @Override
    @MethodLogger
    public CompletableFuture<List<ThreadDtoOut>> getAllThreadRecords() throws ExecutionException, InterruptedException {
        getCurrentThreadStatus().get();
        List<ThreadPool> threadData = threadRepository.findLatestThreads(PageRequest.of(0, 60));
        List<ThreadDtoOut> threadDtoOutList = threadData.stream()
                .map(ThreadPoolMapper::mapToThreadDto)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(threadDtoOutList);
    }

    @Async("customTaskExecutor")
    @Override
    @MethodLogger
    public CompletableFuture<List<ThreadDtoOut>> getAllThreadRecordsByType(String name) throws ExecutionException, InterruptedException {
        getCurrentThreadStatus().get();
//        List<ThreadPool> threadData = threadRepository.findLatestThreadsByName(
//                name,
//                PageRequest.of(0, 60));
        Pageable pageable = PageRequest.of(0, 60, Sort.by(Sort.Direction.DESC, "createdAt"));
        List<ThreadPool> threadData = threadRepository.findByName(name, pageable);
        List<ThreadDtoOut> threadDtoOutList = threadData.stream()
                .map(ThreadPoolMapper::mapToThreadDto)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(threadDtoOutList);
    }

    @Async("customTaskExecutor")
    @MethodLogger
    public CompletableFuture<ArrayList<Integer>> getStatus(ThreadPoolTaskExecutor executor) {
        ArrayList<Integer> threadList = new ArrayList<>();

        threadList.add(threadPoolConfig.getActiveThreads(executor));
        threadList.add(threadPoolConfig.getIdleThreads(executor));
        threadList.add(threadPoolConfig.getTotalThreads(executor));

        return CompletableFuture.completedFuture(threadList);
    }
}
