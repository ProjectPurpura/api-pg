package org.purpura.apipg.repository.pedido.base;

import org.purpura.apipg.model.pedido.PedidoResiduoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoResiduoRepository extends JpaRepository<PedidoResiduoModel, Long> {
    boolean existsByIdResiduoAndPedidoIdPedido(String idResiduo, Long idPedido);

    @Query(value = "SELECT * FROM residuopedido WHERE residuopedido.fkpedido = ?1", nativeQuery = true)
    List<PedidoResiduoModel> findAllByPedidoId(Long idPedido);
}