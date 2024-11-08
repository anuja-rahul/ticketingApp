package org.example.ticketingapp.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends UserDTO{
    private long id;
    @Pattern(regexp = "^\\S+$", message = "No whitespaces are allowed in username")
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "^\\S+$", message = "No whitespaces are allowed in password")
    private String password;
    private boolean vip;
}
