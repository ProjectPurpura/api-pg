package org.purpura.apipg.service.pedido;

import lombok.RequiredArgsConstructor;
import org.purpura.apipg.dto.mapper.pedido.PedidoResiduoMapper;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoResponseDTO;
import org.purpura.apipg.model.pedido.PedidoModel;
import org.purpura.apipg.model.pedido.PedidoResiduoModel;
import org.purpura.apipg.repository.pedido.PedidoResiduoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoResiduoService {
    private final PedidoResiduoMapper pedidoResiduoMapper;
    private final PedidoResiduoRepository pedidoResiduoRepository;


    public List<PedidoResiduoResponseDTO> getResiduosByPedido(Long pedidoId) {
        return pedidoResiduoMapper
                .toResponseList(pedidoResiduoRepository.findAllByPedidoIdPedido(pedidoId));
    }

    public PedidoResiduoResponseDTO addResiduoToPedido(PedidoModel pedido, PedidoResiduoRequestDTO residuoRequestDTO) {
        PedidoResiduoModel residuoModel = pedidoResiduoMapper.toModel(residuoRequestDTO);
        residuoModel.setPedido(pedido);
        return pedidoResiduoMapper
                .toResponse(pedidoResiduoRepository.save(residuoModel));

    }


    public Double calculateTotal(Long pedidoId) {
        return pedidoResiduoRepository.findAllByPedidoIdPedido(pedidoId)
                .stream()
                .mapToDouble(r -> (r.getPreco() != null ? r.getPreco() : 0) * (r.getQuantidade() != null ? r.getQuantidade() : 1))
                .sum();
    }
}
