package org.example.ticketingapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Returns HTTP status CONFLICT
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceCapacityException extends RuntimeException {
    public ResourceCapacityException(String message) {
        super(message);
    }
}
