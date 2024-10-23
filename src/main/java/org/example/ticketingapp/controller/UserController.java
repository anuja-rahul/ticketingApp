package org.example.ticketingapp.controller;


import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.CustomerDTO;
import org.example.ticketingapp.dto.UserDTO;
import org.example.ticketingapp.dto.VendorDTO;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.CustomerMapper;
import org.example.ticketingapp.mapper.VendorMapper;
import org.example.ticketingapp.repository.UserRepository;
import org.example.ticketingapp.service.CustomerService;
import org.example.ticketingapp.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private VendorService vendorService;
    private CustomerService customerService;
    private final UserRepository repository;
    private final JwtService jwtService;

    @GetMapping
    public ResponseEntity<UserDTO> getUserByEmail(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();

        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if ("vendor".equalsIgnoreCase(user.getRole().name())) {
            VendorDTO vendorDTO = vendorService.getVendorByEmail(email);
            return ResponseEntity.ok(VendorMapper.mapToUserDto(vendorDTO));
        } else {
            CustomerDTO customerDTO = customerService.getCustomerByEmail(email);
            return ResponseEntity.ok(CustomerMapper.mapToUserDto(customerDTO));
        }

    }
}
