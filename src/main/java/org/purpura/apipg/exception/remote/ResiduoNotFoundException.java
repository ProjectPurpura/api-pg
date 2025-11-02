package org.purpura.apipg.exception.remote;

import jakarta.persistence.EntityNotFoundException;

public class ResiduoNotFoundException extends EntityNotFoundException {
    public ResiduoNotFoundException(String message) {
        super(message);
    }
}
