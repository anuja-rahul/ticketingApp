package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.VendorDTO;
import org.example.ticketingapp.entity.Vendor;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.logger.MethodLogger;
import org.example.ticketingapp.mapper.VendorMapper;
import org.example.ticketingapp.repository.VendorRepository;
import org.example.ticketingapp.service.VendorService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepository;

    @Override
    @MethodLogger
    public void createVendor(VendorDTO vendorDTO) {
        if(vendorRepository.existsByEmail(vendorDTO.getEmail())) {
            throw new DataIntegrityViolationException("Vendor already exists: " + vendorDTO.getEmail());
        }
        Vendor vendor = VendorMapper.mapToVendor(vendorDTO);
        Vendor savedVendor = vendorRepository.save(vendor);
        VendorMapper.mapToVendorDto(savedVendor);
    }

    @Override
    @MethodLogger
    public VendorDTO getVendorByEmail(String email) {
        Vendor vendor = vendorRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found: " + email));
        return VendorMapper.mapToVendorDto(vendor);
    }

    @Override
    @MethodLogger
    public List<VendorDTO> getAllVendors() {
        List<Vendor> vendors = vendorRepository.findAll();
        return vendors.stream()
                .map(VendorMapper::mapToVendorDto)
                .collect(Collectors.toList());
    }
}
