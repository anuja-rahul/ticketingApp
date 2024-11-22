package org.example.ticketingapp.repository;

import org.example.ticketingapp.dto.UserDtoOut;
import org.example.ticketingapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
