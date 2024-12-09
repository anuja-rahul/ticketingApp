package org.example.ticketingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "threads")
@IdClass(ThreadPoolID.class)
@EntityListeners(AuditingEntityListener.class)
public class ThreadPool {

    @Id
    @CreatedDate
    @Column(nullable = false, unique = false)
    private LocalDateTime createdAt;

    @Id
    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false)
    private Integer activeThreads;

    @Column(nullable = false)
    private Integer idleThreads;

    @Column(nullable = false)
    private Integer totalThreads;
}
