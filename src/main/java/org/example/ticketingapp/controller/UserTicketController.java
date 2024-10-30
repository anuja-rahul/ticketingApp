package org.example.ticketingapp.controller;


import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.UserTicketDTO;
import org.example.ticketingapp.dto.UserTicketDTOIn;
import org.example.ticketingapp.entity.Customer;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.UserTicketMapper;
import org.example.ticketingapp.repository.CustomerRepository;
import org.example.ticketingapp.service.UserTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/ticket")
public class UserTicketController {
    private UserTicketService userTicketService;
    private final JwtService jwtService;



    @PostMapping("/create")
    public ResponseEntity<UserTicketDTO> createUserTicket(
            @RequestBody UserTicketDTOIn userTicketDTOin,
            @RequestHeader("Authorization") String token) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            Claims claims = jwtService.extractAllClaims(token);
            String email = claims.getSubject();

//            Customer customer = customerRepository.findByEmail(email)
//                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//
//            UserTicketDTO userTicketDTO = UserTicketMapper.mapToUserTicketDTO(userTicketDTOin, customer.getEmail());
//            UserTicketDTO newUserTicketDTO = userTicketService.createUserTicket(userTicketDTO);

            // TODO: Just for testing
            UserTicketDTO userTicketDTO = new UserTicketDTO("event1", "test1@mail.com", 2);
            UserTicketDTO newUserTicketDTO = userTicketService.createUserTicket(userTicketDTO);


            return new ResponseEntity<>(newUserTicketDTO, HttpStatus.CREATED);

        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}
