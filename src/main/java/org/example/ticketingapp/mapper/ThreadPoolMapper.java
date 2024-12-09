package org.example.ticketingapp.mapper;

import org.example.ticketingapp.dto.ThreadDtoOut;
import org.example.ticketingapp.entity.ThreadPool;

public class ThreadPoolMapper {
    public static ThreadPool mapToThreadPool(ThreadDtoOut threadDtoOut) {
        return  new ThreadPool(
                threadDtoOut.getCreatedAt(),
                threadDtoOut.getName(),
                threadDtoOut.getActiveThreads(),
                threadDtoOut.getIdleThreads(),
                threadDtoOut.getTotalThreads()
        );
    };

    public static ThreadDtoOut mapToThreadDto(ThreadPool threadPool) {
        return new ThreadDtoOut(
                threadPool.getCreatedAt(),
                threadPool.getName(),
                threadPool.getActiveThreads(),
                threadPool.getIdleThreads(),
                threadPool.getTotalThreads()
        );
    };
}
