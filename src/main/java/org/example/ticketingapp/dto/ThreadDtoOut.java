package org.example.ticketingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadDtoOut {
    private String threadName;
    private int activeThreads;
    private int idleThreads;
    private int totalThreads;

}
