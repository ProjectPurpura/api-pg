package org.purpura.apipg.model.pedido.state;

import org.purpura.apipg.model.pedido.PedidoStatus;

public class CanceladoState implements PedidoState {
    @Override
    public PedidoStatus getStatus() {
        return PedidoStatus.CANCELADO;
    }
    @Override
    public PedidoState aprovar() {
        throw new IllegalStateException("Pedido cancelado não pode ser aprovado");
    }

    @Override
    public PedidoState cancelar() {
        throw new IllegalStateException("Pedido já está cancelado");
    }

    @Override
    public PedidoState concluir() {
        throw new IllegalStateException("Pedido cancelado não pode ser concluído");
    }
}