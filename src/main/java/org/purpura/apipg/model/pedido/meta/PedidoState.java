package org.purpura.apipg.model.pedido.meta;

import org.purpura.apipg.model.pedido.meta.PedidoStatus;

public interface PedidoState {
    PedidoStatus getStatus();
    PedidoState aprovar();
    PedidoState cancelar();
    PedidoState concluir();
}
