package org.purpura.apipg.service.pedido.pagamento;

import org.purpura.apipg.exception.base.NotFoundException;


public class PagamentoNotFoundException extends NotFoundException {

    /**
     * Constructor.
     * @param id
     */
    public PagamentoNotFoundException(Long id) {
        super(String.format("Pagamento com id %d não encontrado", id));
    }
}
