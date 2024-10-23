package org.example.ticketingapp.auth;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.ticketingapp.dto.CustomerDTO;
import org.example.ticketingapp.dto.VendorDTO;
import org.example.ticketingapp.service.CustomerService;
import org.example.ticketingapp.service.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService service;
    private final VendorService vendorService;
    private final CustomerService customerService;

    @Operation(summary = "Register a new user (vendor/customer)")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "User details for registration.", required = true)
            @RequestBody RegisterRequest request) {

        if ("vendor".equalsIgnoreCase(request.getRole())) {
            VendorDTO vendorDTO = new VendorDTO();
            vendorDTO.setName(request.getName());
            vendorDTO.setEmail(request.getEmail());
            vendorDTO.setPassword(request.getPassword());
            vendorService.createVendor(vendorDTO);
        } else if ("customer".equalsIgnoreCase(request.getRole())) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setName(request.getName());
            customerDTO.setEmail(request.getEmail());
            customerDTO.setPassword(request.getPassword());
            customerService.createCustomer(customerDTO);
        }

        return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Authenticate a user (vendor/customer)")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}
