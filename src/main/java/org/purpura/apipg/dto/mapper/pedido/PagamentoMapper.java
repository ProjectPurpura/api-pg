package org.purpura.apipg.dto.mapper.pedido;

import org.purpura.apipg.dto.mapper.base.BeanUtilMapper;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoResponseDTO;
import org.purpura.apipg.model.pedido.pagamento.PagamentoModel;
import org.purpura.apipg.service.pedido.base.PedidoService;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper extends BeanUtilMapper<PagamentoModel, PagamentoRequestDTO, PagamentoResponseDTO> {
    private final PedidoService pedidoService;

    public PagamentoMapper(PedidoService pedidoService) {
        super(PagamentoModel.class, PagamentoResponseDTO.class);
        this.pedidoService = pedidoService;
    }

    @Override
    public PagamentoModel toModel(PagamentoRequestDTO dto) {
        PagamentoModel model = super.toModel(dto);
        if (dto.getIdPedido() != null) {
            model.setPedido(pedidoService.findById(dto.getIdPedido()));
        }
        return model;
    }
}
