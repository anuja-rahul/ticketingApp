package org.example.ticketingapp.dto;


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
    @Pattern(regexp = "^\\S+$", message = "No whitespaces are allowed")
    private String name;
    private String email;
    private String password;
}
