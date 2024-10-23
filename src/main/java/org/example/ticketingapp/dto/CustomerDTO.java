package org.example.ticketingapp.dto;


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
    private String name;
    private String email;
    private String password;
}
