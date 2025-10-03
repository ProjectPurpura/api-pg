package org.purpura.apipg.model.pedido.state;

import org.purpura.apipg.model.pedido.PedidoStatus;

public interface PedidoState {
    PedidoStatus getStatus();
    PedidoState aprovar();
    PedidoState cancelar();
    PedidoState concluir();
}
