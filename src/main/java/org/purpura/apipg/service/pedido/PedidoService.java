package org.purpura.apipg.service.pedido;

import lombok.RequiredArgsConstructor;
import org.purpura.apipg.dto.mapper.pedido.PedidoMapper;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoResponseDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResponseDTO;
import org.purpura.apipg.exception.pedido.PedidoNotFoundException;
import org.purpura.apipg.model.pedido.PedidoModel;
import org.purpura.apipg.repository.pedido.PedidoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final PedidoResiduoService pedidoResiduoService;

    private PedidoModel findById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));
    }

    private PedidoResponseDTO save(PedidoModel pedidoModel) {
        return pedidoMapper.toResponse(pedidoRepository.save(pedidoModel));
    }

    @Transactional
    public PedidoResponseDTO save(PedidoRequestDTO pedidoRequestDTO) {
        return save(pedidoMapper.toModel(pedidoRequestDTO));
    }

    @Transactional
    public PedidoResponseDTO update(Long id, PedidoRequestDTO pedidoRequestDTO) {
        PedidoModel pedidoModel = findById(id);
        BeanUtils.copyProperties(pedidoRequestDTO, pedidoModel);
        return save(pedidoModel);
    }

    @Transactional
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    public List<PedidoResponseDTO> findAll() {
        return pedidoMapper.toResponseList(pedidoRepository.findAll());
    }

    public PedidoResponseDTO findByIdResponse(Long id) {
        return pedidoMapper.toResponse(findById(id));
    }

    public List<PedidoResponseDTO> findAllByComprador(String recebedor) {
        return pedidoMapper
                .toResponseList(pedidoRepository.findAllByComprador(recebedor));
    }

    public List<PedidoResponseDTO> findAllByVendedor(String entregador) {
        return pedidoMapper
                .toResponseList(pedidoRepository.findAllByVendedor(entregador));
    }

    // region RESIDUOS
    @Transactional
    public PedidoResiduoResponseDTO addResiduo(Long pedidoId, PedidoResiduoRequestDTO pedidoResiduoRequestDTO) {
        PedidoModel pedido = findById(pedidoId);
        PedidoResiduoResponseDTO pedidoResiduoResponseDTO = pedidoResiduoService
                .addResiduoToPedido(pedido, pedidoResiduoRequestDTO);

        pedido.setValorTotal(pedidoResiduoService.calculateTotal(pedidoId));

        pedidoRepository.save(pedido);

        return pedidoResiduoResponseDTO;
    }

}
