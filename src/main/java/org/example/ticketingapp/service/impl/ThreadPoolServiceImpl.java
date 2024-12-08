package org.example.ticketingapp.service.impl;


import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.executor.ThreadPoolConfig;
import org.example.ticketingapp.dto.ThreadDtoOut;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

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
        return null;
    }
}
