package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.VendorDTO;
import org.example.ticketingapp.entity.Vendor;
import org.example.ticketingapp.mapper.VendorMapper;
import org.example.ticketingapp.repository.VendorRepository;
import org.example.ticketingapp.service.VendorService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepository;

    @Override
    public VendorDTO createVendor(VendorDTO vendorDTO) {

        Vendor vendor = VendorMapper.mapToVendor(vendorDTO);
        Vendor savedVendor = vendorRepository.save(vendor);
        return VendorMapper.mapToVendorDto(savedVendor);
    }
}
