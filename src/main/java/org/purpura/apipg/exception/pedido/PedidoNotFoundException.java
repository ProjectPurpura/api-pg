package org.purpura.apipg.exception.pedido;

import org.purpura.apipg.exception.base.NotFoundException;

public class PedidoNotFoundException extends NotFoundException {
    public PedidoNotFoundException(Long idPedido) {
        super(String.format("Pedido com id %d não encontrado.", idPedido));
    }
}
