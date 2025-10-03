package org.purpura.apipg.repository.pedido;

import org.purpura.apipg.model.pedido.PedidoResiduoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoResiduoRepository extends JpaRepository<PedidoResiduoModel, Long> {

}
