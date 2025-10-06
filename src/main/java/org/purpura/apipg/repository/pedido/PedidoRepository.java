package org.purpura.apipg.repository.pedido;

import org.purpura.apipg.model.pedido.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
    @Query(value = "SELECT * FROM pedido WHERE pedido.fk_recebedor = ?1", nativeQuery = true)
    List<PedidoModel> findAllByComprador(String compradorId);

    @Query(value = "SELECT * FROM pedido WHERE pedido.fk_entregador = ?1", nativeQuery = true)
    List<PedidoModel> findAllByVendedor(String vendedorId);

}
