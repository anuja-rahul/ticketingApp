package org.example.ticketingapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    @Pattern(regexp = "^\\S+$", message = "No whitespaces are allowed in the username")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
}
