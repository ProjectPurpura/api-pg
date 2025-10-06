package org.purpura.apipg.model.pedido.meta;

public class PendenteState implements PedidoState {
    @Override
    public PedidoStatus getStatus() {
        return PedidoStatus.PENDENTE;
    }

    @Override
    public PedidoState aprovar() {
        return new AprovadoState();
    }

    @Override
    public PedidoState cancelar() {
        return new CanceladoState();
    }

    @Override
    public PedidoState concluir() {
        throw new IllegalStateException("Pedido pendente não pode ser concluído diretamente");
    }
}
