package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.AdminDTO;
import org.example.ticketingapp.entity.Admin;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.AdminMapper;
import org.example.ticketingapp.repository.AdminRepository;
import org.example.ticketingapp.service.AdminService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AdminServiceImpl  implements AdminService {

    private AdminRepository adminRepository;

    @Override
    public void createAdmin(AdminDTO adminDTO) {
        if(adminRepository.existsByEmail(adminDTO.getEmail())) {
            throw new DataIntegrityViolationException("Admin already exists: " + adminDTO.getEmail());
        }
        Admin admin = AdminMapper.mapToAdmin(adminDTO);
        Admin savedAdmin = adminRepository.save(admin);
        AdminMapper.mapToAdminDto(savedAdmin);
    }

    @Override
    public AdminDTO getAdminByEmail(String email) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found: " + email));
        return AdminMapper.mapToAdminDto(admin);
    }
}
