package org.example.ticketingapp.controller;


import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.JwtService;
import org.example.ticketingapp.dto.UserDTO;
import org.example.ticketingapp.dto.UserDtoOut;
import org.example.ticketingapp.dto.VendorDTO;
import org.example.ticketingapp.entity.User;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.VendorMapper;
import org.example.ticketingapp.repository.UserRepository;
import org.example.ticketingapp.service.UserService;
import org.example.ticketingapp.service.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for handling user-related requests.
 * This class provides endpoints for managing users.
 * It uses {@link UserService} and {@link VendorService} to perform operations related to users and vendors.
 * The class is annotated with {@link RestController} to indicate that it is a RESTful web service controller.
 * It is also annotated with {@link CrossOrigin} to allow cross-origin requests.
 * The base URL for all endpoints in this class is "/api/user".
 */
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private VendorService vendorService;
    private final UserRepository repository;
    private final JwtService jwtService;
    private UserService userService;


    /**
     * Get the user data if a valid token is included in the request header.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the user data
     */
    @Operation(summary = "Get the user profile information, if logged in as the user")
    @GetMapping
    public ResponseEntity<UserDtoOut> getUser(
            @RequestHeader("Authorization") String token) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();

        UserDtoOut userDtoOut = userService.getUserByEmail(email);

        return ResponseEntity.ok(userDtoOut);
    }

    /**
     * Get all user data if a valid admin token is included in the request header.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the list of all users
     */
    @Operation(summary = "Get all user profile information, if logged in as an admin")
    @GetMapping("/all")
    public ResponseEntity<List<UserDtoOut>> getAllUsers(
            @RequestHeader("Authorization") String token) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        Claims claims = jwtService.extractAllClaims(token);
        String email = claims.getSubject();

        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if("admin".equalsIgnoreCase(user.getRole().name())) {
            return ResponseEntity.ok(userService.getAllUsers());
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    /**
     * Get a sequence of all vendor data if a valid customer token is included in the request header.
     *
     * @param token the JWT token included in the request header
     * @return a {@link ResponseEntity} containing the list of all vendors
    */
    @Operation(summary = "Get a list of all vendors, only if logged in as a customer")
    @GetMapping("/vendors")
    public ResponseEntity<List<UserDTO>> getAllVendors(
            @RequestHeader("Authorization") String token
    ) {

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
