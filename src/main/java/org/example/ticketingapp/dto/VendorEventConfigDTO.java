package org.example.ticketingapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorEventConfigDTO extends VendorEventConfigDTOIn {
    private long id;
    private String email;
    @NotBlank(message = "event name is required")
    @Pattern(regexp = "^\\S+$", message = "No whitespaces are allowed in event name")
    private String eventName;
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;
}
