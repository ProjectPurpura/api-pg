package org.purpura.apipg.model.pedido.meta;


import org.purpura.apipg.model.pedido.meta.state.*;

public record PedidoStatusStateAdapter(PedidoStatus status) {

    public PedidoState get() {
        if (this.status == null) {
            return new AbertoState();
        }

        switch (this.status) {
            case APROVADO -> {
                return new AprovadoState();
            }
            case CONCLUIDO -> {
                return new ConcluidoState();
            }
            case CANCELADO -> {
                return new CanceladoState();
            }
            default -> {
                return new AbertoState();
            }
        }
    }
}
