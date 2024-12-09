package org.example.ticketingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadDtoOut {
    private LocalDateTime createdAt;
    private String name;
    private int activeThreads;
    private int idleThreads;
    private int totalThreads;

}
