package org.purpura.apipg.model.pedido.meta;


public class AprovadoState implements PedidoState {
    @Override
    public PedidoStatus getStatus() {
        return PedidoStatus.APROVADO;
    }

    @Override
    public PedidoState aprovar() {
        throw new IllegalStateException("Pedido já está aprovado");
    }

    @Override
    public PedidoState cancelar() {
        return new CanceladoState();
    }

    @Override
    public PedidoState concluir() {
        return new ConcluidoState();
    }
}
