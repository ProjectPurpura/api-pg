package org.purpura.apipg.repository.pedido.pagamento;

import org.purpura.apipg.model.pedido.pagamento.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoModel, Long> {
    List<PagamentoModel> findAllByPedidoIdPedido(Long idPedido);
}
