package org.purpura.apipg.exception;

import jakarta.persistence.EntityNotFoundException;

public class ResiduoNotFoundException extends EntityNotFoundException {
    public ResiduoNotFoundException(String message) {
        super(message);
    }
}
