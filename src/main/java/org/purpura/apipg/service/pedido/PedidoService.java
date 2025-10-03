package org.purpura.apipg.service.pedido;

import org.purpura.apipg.dto.mapper.pedido.PedidoMapper;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResponseDTO;
import org.purpura.apipg.exception.pedido.PedidoNotFoundException;
import org.purpura.apipg.model.pedido.PedidoModel;
import org.purpura.apipg.repository.pedido.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    public List<PedidoResponseDTO> findAllByRecebedor(String recebedor) {
        return pedidoMapper
                .toResponseList(pedidoRepository.findAllByRecebedor(recebedor));
    }

    private PedidoModel findById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));
    }

    @Transactional
    public PedidoResponseDTO save(PedidoModel pedidoModel) {
        return pedidoMapper.toResponse(pedidoRepository.save(pedidoModel));
    }


    public PedidoResponseDTO findByIdResponse(Long id) {
        return pedidoMapper.toResponse(findById(id));
    }

    @Transactional
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

}
