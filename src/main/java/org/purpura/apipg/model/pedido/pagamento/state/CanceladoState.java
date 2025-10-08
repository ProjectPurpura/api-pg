package org.purpura.apipg.model.pedido.pagamento.state;

import org.purpura.apipg.model.pedido.pagamento.PagamentoStatus;

public class CanceladoState implements PagamentoState {
    @Override
    public PagamentoStatus getStatus() {
        return PagamentoStatus.CANCELADO;
    }

    @Override
    public PagamentoState concluir() {
        throw new IllegalStateException("Pagamento cancelado não pode ser concluído");
    }

    @Override
    public PagamentoState cancelar() {
        throw new IllegalStateException("Pagamento já está cancelado");
    }
}
