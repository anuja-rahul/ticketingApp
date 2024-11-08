package org.example.ticketingapp.mapper;

import org.example.ticketingapp.dto.UserDtoOut;
import org.example.ticketingapp.entity.User;

public class UserMapper {
    public static UserDtoOut mapToUserDtoOut(User user) {
        return new UserDtoOut(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
