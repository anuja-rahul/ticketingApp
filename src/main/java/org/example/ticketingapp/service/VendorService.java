package org.example.ticketingapp.service;

import org.example.ticketingapp.dto.VendorDTO;

import java.util.List;

public interface VendorService {

    VendorDTO createVendor(VendorDTO vendorDTO);

    VendorDTO getVendorByEmail(String email);

    List<VendorDTO> getAllVendors();
}
