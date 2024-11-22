package org.example.ticketingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IllegalResourceException extends RuntimeException {
    public IllegalResourceException(String message) {
        super(message);
    }
}
