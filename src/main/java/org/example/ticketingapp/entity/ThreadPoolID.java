package org.example.ticketingapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadPoolID implements Serializable {
    private LocalDateTime createdAt;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ThreadPoolID that = (ThreadPoolID) o;
        return Objects.equals(createdAt, that.createdAt) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, name);
    }
}
