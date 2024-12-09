package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.ThreadPool;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ThreadPoolRepository extends JpaRepository<ThreadPool, LocalDateTime> {

    @Query("SELECT t FROM threads t ORDER BY t.createdAt DESC")
    List<ThreadPool> findLatestThreads(PageRequest pageRequest);
}
