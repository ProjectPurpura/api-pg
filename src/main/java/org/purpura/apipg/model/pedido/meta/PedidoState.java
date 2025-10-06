package org.purpura.apipg.model.pedido.meta;

public interface PedidoState {
    PedidoStatus getStatus();
    PedidoState aprovar();
    PedidoState cancelar();
    PedidoState concluir();
}
