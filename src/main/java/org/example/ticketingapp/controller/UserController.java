package org.example.ticketingapp.controller;


import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private VendorService vendorService;
    private CustomerService customerService;
    private final UserRepository repository;
    private final JwtService jwtService;


    /**
     * Get the user data if a valid token is included in the request header
     */
    @Operation(summary = "Get the user profile information, if logged in")
    @GetMapping
    public ResponseEntity<UserDTO> getUserByEmail(
            @RequestHeader("Authorization") String token) {

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
        // could implement pre declared superuser logic here, if needed

    }

    /**
     * Get a sequence of all vendor data if a valid customer token is included in the request header
     */
    @Operation(summary = "Get a list of all vendors, only if logged in as a customer")
    @GetMapping("/vendors")
    public ResponseEntity<List<UserDTO>> getAllVendors(@RequestHeader("Authorization") String token) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();

        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Only allows Customers to access the vendor pool
        if ("customer".equalsIgnoreCase(user.getRole().name())) {
            List<VendorDTO> vendors = vendorService.getAllVendors();
            return ResponseEntity.ok(vendors.stream()
                    .map(VendorMapper::mapToUserDto)
                    .collect(Collectors.toList()));
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


    }
}
