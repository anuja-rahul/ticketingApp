package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.VendorEventConfig;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VendorEventConfigRepository extends JpaRepository<VendorEventConfig, Long> {
    Optional<VendorEventConfig> findByEventName(String eventName);
    Optional<List<VendorEventConfig>> findAllByEmail(String email, Sort sort);
    void deleteByEventName(String eventName);
    boolean existsByEventName(String eventName);
//    boolean existsByEmail(String email);
}
