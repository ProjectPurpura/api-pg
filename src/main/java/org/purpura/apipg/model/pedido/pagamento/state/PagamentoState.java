package org.purpura.apipg.model.pedido.pagamento.state;

import org.purpura.apipg.model.pedido.pagamento.PagamentoStatus;

public interface PagamentoState {
    PagamentoStatus getStatus();
    PagamentoState concluir();
    PagamentoState cancelar();
}
