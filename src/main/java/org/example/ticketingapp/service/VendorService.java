package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.VendorDTO;

public interface VendorService {
    VendorDTO createVendor(VendorDTO vendorDTO);

    VendorDTO getVendorByEmail(String email);
}
