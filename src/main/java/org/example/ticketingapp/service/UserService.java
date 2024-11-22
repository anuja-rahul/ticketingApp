package org.example.ticketingapp.service;


import org.example.ticketingapp.dto.UserDtoOut;

import java.util.List;

public interface UserService {
    UserDtoOut getUserByEmail(String email);
    List<UserDtoOut> getAllUsers();
}
