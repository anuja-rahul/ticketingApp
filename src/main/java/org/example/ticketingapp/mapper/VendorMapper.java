package org.example.ticketingapp.mapper;

import org.example.ticketingapp.dto.UserDTO;
import org.example.ticketingapp.dto.VendorDTO;
import org.example.ticketingapp.entity.Vendor;

public class VendorMapper {


    public static VendorDTO mapToVendorDto(Vendor vendor) {
        return new VendorDTO(
                vendor.getId(),
                vendor.getName(),
                vendor.getEmail(),
                vendor.getPassword()
        );
    }

    public static Vendor mapToVendor(VendorDTO vendorDTO) {
        return new Vendor(
                vendorDTO.getId(),
                vendorDTO.getName(),
                vendorDTO.getEmail(),
                vendorDTO.getPassword()
        );
    }

    public static UserDTO mapToUserDto(VendorDTO vendorDTO) {
        return new UserDTO(
                vendorDTO.getId(),
                vendorDTO.getName(),
                vendorDTO.getEmail()
        );
    }
}
