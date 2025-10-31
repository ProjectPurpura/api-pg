package org.purpura.apipg.service.pedido.base;

import lombok.RequiredArgsConstructor;
import org.purpura.apipg.dto.mapper.pedido.PedidoResiduoMapper;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoResponseDTO;
import org.purpura.apipg.exception.base.DuplicateDataException;
import org.purpura.apipg.exception.pedido.PedidoResiduoNotFoundException;
import org.purpura.apipg.model.pedido.PedidoModel;
import org.purpura.apipg.model.pedido.PedidoResiduoModel;
import org.purpura.apipg.repository.pedido.base.PedidoResiduoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoResiduoService {
    private final PedidoResiduoMapper pedidoResiduoMapper;
    private final PedidoResiduoRepository pedidoResiduoRepository;



    List<PedidoResiduoModel> findResiduosByPedido(Long pedidoId) {
        return pedidoResiduoRepository.findAllByPedidoId(pedidoId);
    }

    public List<PedidoResiduoResponseDTO> getResiduosByPedido(Long pedidoId) {
        return pedidoResiduoMapper
                .toResponseList(pedidoResiduoRepository.findAllByPedidoId(pedidoId));
    }

    public PedidoResiduoResponseDTO addResiduoToPedido(PedidoModel pedido, PedidoResiduoRequestDTO residuoRequestDTO) {
        if (pedidoResiduoRepository.existsByIdResiduoAndPedidoIdPedido(residuoRequestDTO.getIdResiduo(), pedido.getIdPedido())) {
            throw new DuplicateDataException("Resíduo já adicionado ao pedido.");
        }
        PedidoResiduoModel residuoModel = pedidoResiduoMapper.toModel(residuoRequestDTO);
        residuoModel.setPedido(pedido);
        return pedidoResiduoMapper
                .toResponse(pedidoResiduoRepository.save(residuoModel));

    }

    public PedidoResiduoResponseDTO updateResiduo(PedidoModel pedidoModel, Long residuoId, PedidoResiduoRequestDTO residuoRequestDTO) {
        PedidoResiduoModel existingResiduo = pedidoResiduoRepository.findById(residuoId)
                .orElseThrow(() -> new IllegalArgumentException("Resíduo não encontrado com ID: " + residuoId));

        if (!existingResiduo.getIdResiduo().equals(residuoRequestDTO.getIdResiduo()) &&
                pedidoResiduoRepository.existsByIdResiduoAndPedidoIdPedido(residuoRequestDTO.getIdResiduo(), pedidoModel.getIdPedido())) {
            throw new DuplicateDataException("Resíduo já adicionado ao pedido.");
        }
        BeanUtils.copyProperties(residuoRequestDTO, existingResiduo);

        PedidoResiduoModel updatedResiduo = pedidoResiduoRepository.save(existingResiduo);
        return pedidoResiduoMapper.toResponse(updatedResiduo);
    }

    public void deleteResiduo(PedidoModel pedidoModel, Long residuoId) {
        PedidoResiduoModel existingResiduo = pedidoResiduoRepository.findById(residuoId)
                .orElseThrow(() -> new PedidoResiduoNotFoundException(residuoId));

        if (!existingResiduo.getPedido().getIdPedido().equals(pedidoModel.getIdPedido())) {
            throw new IllegalArgumentException("Resíduo não pertence ao pedido especificado.");
        }

        pedidoResiduoRepository.delete(existingResiduo);
    }

    public Double calculateTotal(Long pedidoId) {
        return pedidoResiduoRepository.findAllByPedidoId(pedidoId)
                .stream()
                .mapToDouble(r -> (r.getPreco() != null ? r.getPreco() : 0) * (r.getQuantidade() != null ? r.getQuantidade() : 1))
                .sum();
    }
}
