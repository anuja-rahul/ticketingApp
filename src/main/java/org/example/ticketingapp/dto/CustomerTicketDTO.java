package org.example.ticketingapp.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTicketDTO {

    @Email(message = "Invalid email")
    private String customerEmail;
    @NotEmpty
    @Pattern(regexp = "^\\S+$", message = "No whitespaces are allowed in event name")
    private String eventName;
    private int ticketsBought;
}
