package org.example.ticketingapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadPoolID implements Serializable {
    private LocalDateTime createdAt;
    private String name;
}
