package org.purpura.apipg.dto.mapper.pedido;

import org.purpura.apipg.dto.mapper.base.BeanUtilMapper;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoResponseDTO;
import org.purpura.apipg.model.pedido.PedidoResiduoModel;
import org.springframework.stereotype.Component;

@Component
public class PedidoResiduoMapper extends BeanUtilMapper<PedidoResiduoModel, PedidoResiduoRequestDTO, PedidoResiduoResponseDTO> {
    public PedidoResiduoMapper() {
        super(PedidoResiduoModel.class, PedidoResiduoResponseDTO.class);
    }
}
