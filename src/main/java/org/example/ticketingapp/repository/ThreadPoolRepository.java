package org.example.ticketingapp.repository;

import org.example.ticketingapp.entity.ThreadPool;
import org.example.ticketingapp.entity.ThreadPoolID;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThreadPoolRepository extends JpaRepository<ThreadPool, ThreadPoolID> {

    @Query("SELECT t FROM threads t ORDER BY t.createdAt DESC")
    List<ThreadPool> findLatestThreads(PageRequest pageRequest);

    @Query("SELECT t FROM threads t WHERE t.name = :name ORDER BY t.createdAt DESC")
    List<ThreadPool> findLatestThreadsByName(@Param("name") String name, PageRequest pageRequest);

    List<ThreadPool> findByName(String name, Pageable pageable);

}
