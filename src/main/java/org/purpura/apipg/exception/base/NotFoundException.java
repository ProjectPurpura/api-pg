package org.purpura.apipg.exception.base;

import jakarta.persistence.EntityNotFoundException;

public class NotFoundException extends EntityNotFoundException {
    public NotFoundException(String message) {
        super(String.format("Erro de dados não encontrados; %s", message));
    }
}
