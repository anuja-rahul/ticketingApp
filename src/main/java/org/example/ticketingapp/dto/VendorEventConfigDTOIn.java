package org.example.ticketingapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorEventConfigDTOIn {
    private long id;
    @NotBlank(message = "event name is required")
    @Pattern(regexp = "^\\S+$", message = "No whitespaces are allowed in event name")
    private String eventName;
}
