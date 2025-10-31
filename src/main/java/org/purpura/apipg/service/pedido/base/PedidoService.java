package org.purpura.apipg.service.pedido.base;

import lombok.RequiredArgsConstructor;
import org.purpura.apipg.dto.mapper.pedido.PedidoMapper;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoResponseDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResponseDTO;
import org.purpura.apipg.dto.schemas.remote.EstoqueDownturn;
import org.purpura.apipg.dto.schemas.remote.ResiduoDownturnRequestDTO;
import org.purpura.apipg.exception.pedido.PedidoNotFoundException;
import org.purpura.apipg.model.pedido.PedidoModel;
import org.purpura.apipg.model.pedido.PedidoResiduoModel;
import org.purpura.apipg.model.pedido.meta.PedidoStatus;
import org.purpura.apipg.repository.pedido.base.PedidoRepository;
import org.purpura.apipg.service.remote.MongoApiService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final PedidoResiduoService pedidoResiduoService;
    private final MongoApiService mongoApiService;

    public PedidoModel findById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));
    }

    private PedidoModel findByIdForUpdate(Long id) {
        return pedidoRepository.findByIdForUpdate(id)
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
        PedidoModel pedidoModel = findById(id);
        ensurePedidoIsAberto(pedidoModel);
        pedidoRepository.delete(pedidoModel);
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

    private static void ensurePedidoIsAberto(PedidoModel pedido) {
        if (pedido.getStatus() != PedidoStatus.ABERTO) {
            throw new IllegalStateException("Não se pode modificar ou apagar os resíduos de um pedido que não está em aberto.");
        }
    }

    private static void ensurePedidoDelecaoIsAberto(PedidoModel pedido) {
        if (pedido.getStatus() != PedidoStatus.ABERTO) {
            throw new IllegalStateException("Não se pode apagar pedidos que não estão em aberto.");
        }
    }

    @Transactional
    public PedidoResiduoResponseDTO addResiduo(Long pedidoId, PedidoResiduoRequestDTO pedidoResiduoRequestDTO) {
        PedidoModel pedido = findById(pedidoId);

        ensurePedidoIsAberto(pedido);

        mongoApiService.downturnStock(pedido.getIdVendedor(), new EstoqueDownturn(pedidoResiduoRequestDTO.getIdResiduo(), pedidoResiduoRequestDTO.getQuantidade()));

        PedidoResiduoResponseDTO pedidoResiduoResponseDTO = pedidoResiduoService
                .addResiduoToPedido(pedido, pedidoResiduoRequestDTO);

        pedido.setValorTotal(pedidoResiduoService.calculateTotal(pedidoId));

        pedidoRepository.save(pedido);

        return pedidoResiduoResponseDTO;
    }


    @Transactional
    public PedidoResiduoResponseDTO updateResiduo(Long pedidoId, Long residuoId, PedidoResiduoRequestDTO pedidoResiduoRequestDTO) {
        PedidoModel pedido = findById(pedidoId);
        ensurePedidoIsAberto(pedido);
        PedidoResiduoResponseDTO responseDTO = pedidoResiduoService.updateResiduo(pedido, residuoId, pedidoResiduoRequestDTO);
        pedido.setValorTotal(pedidoResiduoService.calculateTotal(pedidoId));
        pedidoRepository.save(pedido);
        return responseDTO;
    }

    @Transactional
    public void deleteResiduo(Long pedidoId, Long residuoId) {
        PedidoModel pedido = findById(pedidoId);
        ensurePedidoDelecaoIsAberto(pedido);

        PedidoResiduoModel residuo = pedidoResiduoService.findResiduoById(residuoId);
        mongoApiService.downturnStock(pedido.getIdVendedor(), new EstoqueDownturn(residuo.getIdResiduo(), -residuo.getQuantidade()));

        pedidoResiduoService.deleteResiduo(pedido, residuoId);
        pedido.setValorTotal(pedidoResiduoService.calculateTotal(pedidoId));
        pedidoRepository.save(pedido);
    }

    // region CICLO

    @Transactional
    public PedidoResponseDTO aprovar(Long pedidoId) {
        PedidoModel pedido = findById(pedidoId);
        pedido.aprovar();
        return save(pedido);
    }

    @Transactional
    public PedidoResponseDTO concluir(Long pedidoId) {
        PedidoModel pedido = findById(pedidoId);
        pedido.concluir();
        return save(pedido);
    }

    @Transactional
    public PedidoResponseDTO cancelar(Long pedidoId) {
        PedidoModel pedido = findByIdForUpdate(pedidoId);

        ensurePedidoDelecaoIsAberto(pedido);

        List<PedidoResiduoModel> residuoModels = pedidoResiduoService.findResiduosByPedido(pedidoId);
        if (!residuoModels.isEmpty()) {
            List<EstoqueDownturn> downturns = residuoModels.stream()
                    .map(r -> new EstoqueDownturn(r.getIdResiduo(), -r.getQuantidade()))
                    .collect(Collectors.toList());
            mongoApiService.downturnStock(pedido.getIdVendedor(), new ResiduoDownturnRequestDTO(downturns));
        }

        pedido.cancelar();
        return save(pedido);
    }
}
