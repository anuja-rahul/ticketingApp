package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.VendorEventConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VendorEventConfigRepository extends JpaRepository<VendorEventConfig, Long> {
    Optional<VendorEventConfig> findByEventName(String eventName);
    List<VendorEventConfig> findAllByEmail(String email);
    boolean existsByEmail(String email);
}
