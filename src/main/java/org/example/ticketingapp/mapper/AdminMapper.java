package org.example.ticketingapp.mapper;

import org.example.ticketingapp.dto.AdminDTO;
import org.example.ticketingapp.dto.UserDTO;
import org.example.ticketingapp.entity.Admin;

public class AdminMapper {

    public static AdminDTO mapToAdminDto(Admin admin) {
        return new AdminDTO(
                admin.getId(),
                admin.getName(),
                admin.getEmail(),
                admin.getPassword()
        );
    }

    public static Admin mapToAdmin(AdminDTO adminDTO) {
        return new Admin(
                adminDTO.getId(),
                adminDTO.getName(),
                adminDTO.getEmail(),
                adminDTO.getPassword()
        );
    }

    public static UserDTO mapToUserDto(AdminDTO adminDTO) {
        return new UserDTO(
                adminDTO.getId(),
                adminDTO.getName(),
                adminDTO.getEmail()
        );
    }
}
