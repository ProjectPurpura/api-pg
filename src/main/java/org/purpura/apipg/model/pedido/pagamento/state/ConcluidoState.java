package org.purpura.apipg.model.pedido.pagamento.state;

import org.purpura.apipg.model.pedido.pagamento.PagamentoStatus;

public class ConcluidoState implements PagamentoState {
    @Override
    public PagamentoStatus getStatus() {
        return PagamentoStatus.CONCLUIDO;
    }

    @Override
    public PagamentoState concluir() {
        throw new IllegalStateException("Pagamento já está concluído");
    }

    @Override
    public PagamentoState cancelar() {
        throw new IllegalStateException("Não se pode cancelar um pagamento que já foi concluído");
    }
}
