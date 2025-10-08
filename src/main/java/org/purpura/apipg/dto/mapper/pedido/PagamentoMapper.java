package org.purpura.apipg.dto.mapper.pedido;

import org.purpura.apipg.dto.mapper.base.BeanUtilMapper;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoResponseDTO;
import org.purpura.apipg.model.pedido.pagamento.PagamentoModel;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper extends BeanUtilMapper<PagamentoModel, PagamentoRequestDTO, PagamentoResponseDTO> {
    public PagamentoMapper() {
        super(PagamentoModel.class, PagamentoResponseDTO.class);
    }
}
