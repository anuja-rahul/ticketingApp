package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
