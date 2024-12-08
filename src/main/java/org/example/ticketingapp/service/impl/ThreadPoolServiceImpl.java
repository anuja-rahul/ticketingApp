package org.example.ticketingapp.service.impl;


import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.executor.ThreadPoolConfig;
import org.example.ticketingapp.dto.ThreadDtoOut;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ThreadPoolServiceImpl {
    private ThreadPoolTaskExecutor taskExecutor;
    private ThreadPoolTaskExecutor ticketExecutor;
    private ThreadPoolTaskExecutor vendorExecutor;
    private ThreadPoolTaskExecutor customerExecutor;
    private ThreadPoolConfig threadPoolConfig;


    public List<ThreadDtoOut> getThreadStatus() {
        ArrayList<Integer> taskList = getStatus(taskExecutor);
        ArrayList<Integer> ticketList = getStatus(ticketExecutor);
        ArrayList<Integer> vendorList = getStatus(vendorExecutor);
        ArrayList<Integer> customerList = getStatus(customerExecutor);

        List<ThreadDtoOut> threadDtoOutList = new ArrayList<>();

        ThreadDtoOut task = new ThreadDtoOut(
                "taskExecutor",
                taskList.get(0),
                taskList.get(1),
                taskList.get(2)
                );
        ThreadDtoOut ticket = new ThreadDtoOut(
                "ticketExecutor",
                ticketList.get(0),
                ticketList.get(1),
                ticketList.get(2)
        );
        ThreadDtoOut vendor = new ThreadDtoOut(
                "vendorExecutor",
                vendorList.get(0),
                vendorList.get(1),
                vendorList.get(2)
        );
        ThreadDtoOut customer = new ThreadDtoOut(
                "customerExecutor",
                customerList.get(0),
                customerList.get(1),
                customerList.get(2)
        );

        threadDtoOutList.add(task);
        threadDtoOutList.add(ticket);
        threadDtoOutList.add(vendor);
        threadDtoOutList.add(customer);


        return threadDtoOutList;
    }

    private ArrayList<Integer> getStatus(ThreadPoolTaskExecutor executor) {
        ArrayList<Integer> threadList = new ArrayList<>();

        threadList.add(threadPoolConfig.getActiveThreads(executor));
        threadList.add(threadPoolConfig.getIdleThreads(executor));
        threadList.add(threadPoolConfig.getTotalThreads(executor));

        return threadList;
    }
}
