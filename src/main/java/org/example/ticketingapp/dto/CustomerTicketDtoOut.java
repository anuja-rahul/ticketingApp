package org.example.ticketingapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTicketDtoOut {
    private String customerEmail;
    private String eventName;
    private int ticketsBought;
}
