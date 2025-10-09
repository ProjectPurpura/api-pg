package org.purpura.apipg.model.pedido.pagamento.state;

import org.purpura.apipg.model.pedido.pagamento.PagamentoStatus;

public class PendenteState implements PagamentoState {
    @Override
    public PagamentoStatus getStatus() {
        return PagamentoStatus.PENDENTE;
    }

    @Override
    public PagamentoState concluir() {
        return new ConcluidoState();
    }

    @Override
    public PagamentoState cancelar() {
        return new CanceladoState();
    }
}
