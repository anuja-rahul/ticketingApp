package org.example.ticketingapp.dto;


import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTicketDTOIn {
    @Pattern(regexp = "^\\S+$", message = "No whitespaces are allowed in event name")
    private String eventName;
}
