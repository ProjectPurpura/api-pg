package org.purpura.apipg.exception.pedido;

import jakarta.persistence.EntityNotFoundException;

public class PedidoResiduoNotFoundException extends EntityNotFoundException {
    public PedidoResiduoNotFoundException(Long idResiduo) {
        super(String.format("Não foi possível encontrar o item %d", idResiduo));
    }
}
