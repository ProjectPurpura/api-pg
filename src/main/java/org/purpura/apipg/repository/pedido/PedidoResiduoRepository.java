package org.purpura.apipg.repository.pedido;

import org.purpura.apipg.model.pedido.PedidoResiduoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoResiduoRepository extends JpaRepository<PedidoResiduoModel, Long> {
    boolean existsByIdResiduoAndPedidoIdPedido(String idResiduo, Long idPedido);

    List<PedidoResiduoModel> findAllByPedidoIdPedido(Long idPedido);
}