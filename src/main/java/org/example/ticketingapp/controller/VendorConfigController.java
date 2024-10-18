package org.example.ticketingapp.controller;


import org.example.ticketingapp.dto.VendorConfigDTO;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/config")
public class VendorConfigController {
    private VendorConfigDTO vendorConfigDTO = new VendorConfigDTO();

    @PostMapping("/")
    public void updateConfig(@RequestBody VendorConfigDTO newVendorConfigDTO) {
        this.vendorConfigDTO = newVendorConfigDTO;
    }

    @GetMapping("/")
    public VendorConfigDTO getConfig() {
        return vendorConfigDTO;
    }
}
