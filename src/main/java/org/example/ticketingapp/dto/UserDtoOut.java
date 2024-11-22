package org.example.ticketingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoOut {
    private long id;
    private String name;
    private String email;
    private String role;
    private LocalDateTime createdAt;
}
