package org.purpura.apipg.model.pedido.meta;


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
