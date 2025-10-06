package org.purpura.apipg.model.pedido.meta;


public class PedidoStatusStateAdapter {
    private final PedidoStatus status;

    public PedidoStatusStateAdapter(PedidoStatus status) {
        this.status = status;
    }

    public PedidoState get() {
        if (this.status == null) {
            return new PendenteState();
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
                return new PendenteState();
            }
        }
    }
}
