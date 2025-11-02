package org.purpura.apipg.exception.remote;

import org.purpura.apipg.exception.base.NotFoundException;

// Repassa a mensagem que vem da API externa
public class ResiduoNotFoundException extends NotFoundException {
    public ResiduoNotFoundException(String message) {
        super(message);
    }
}
