package org.example.ticketingapp.service;


import org.example.ticketingapp.dto.AdminDTO;


public interface AdminService {
    void createAdmin(AdminDTO adminDTO);
    AdminDTO getAdminByEmail(String email);
}
