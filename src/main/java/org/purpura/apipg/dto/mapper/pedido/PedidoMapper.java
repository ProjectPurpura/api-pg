package org.purpura.apipg.dto.mapper.pedido;

import org.purpura.apipg.dto.mapper.base.BeanUtilMapper;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResponseDTO;
import org.purpura.apipg.model.pedido.PedidoModel;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper extends BeanUtilMapper<PedidoModel, PedidoRequestDTO, PedidoResponseDTO> {
    public PedidoMapper() {
        super(PedidoModel.class, PedidoResponseDTO.class);
    }
}
