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
public class VendorDTO extends UserDTO {
    private long id;
    @Pattern(regexp = "^\\S+$", message = "No whitespaces are allowed in the username")
    private String name;
    @Email(message = "Please provide a valid email address")
    private String email;
    @Pattern(regexp = "^\\S+$", message = "No whitespaces are allowed in the password")
    private String password;
}
