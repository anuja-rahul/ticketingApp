package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.VendorDTO;
import org.example.ticketingapp.entity.Vendor;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.VendorMapper;
import org.example.ticketingapp.repository.VendorRepository;
import org.example.ticketingapp.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public VendorDTO getVendorByEmail(String email) {
        Vendor vendor = vendorRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found: " + email));
        return VendorMapper.mapToVendorDto(vendor);
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        List<Vendor> vendors = vendorRepository.findAll();
        return vendors.stream().map(VendorMapper::mapToVendorDto).collect(Collectors.toList());
    }
}
