package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.ThreadDtoOut;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;

public interface ThreadPoolService {
    List<ThreadDtoOut> getThreadStatus();
    ArrayList<Integer> getStatus(ThreadPoolTaskExecutor executor);
}