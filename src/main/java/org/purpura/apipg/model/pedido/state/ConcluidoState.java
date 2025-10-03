package org.purpura.apipg.model.pedido.state;

import org.purpura.apipg.model.pedido.PedidoStatus;

public class ConcluidoState implements PedidoState {
    @Override
    public PedidoStatus getStatus() {
        return PedidoStatus.CONCLUIDO;
    }

    @Override
    public PedidoState aprovar() {
        throw new IllegalStateException("Pedido concluído não pode ser aprovado");
    }

    @Override
    public PedidoState cancelar() {
        throw new IllegalStateException("Pedido concluído não pode ser cancelado");
    }

    @Override
    public PedidoState concluir() {
        throw new IllegalStateException("Pedido já está concluído");
    }
}
