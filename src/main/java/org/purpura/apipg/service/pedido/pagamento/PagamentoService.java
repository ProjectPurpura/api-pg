package org.purpura.apipg.service.pedido.pagamento;

import lombok.RequiredArgsConstructor;
import org.purpura.apipg.dto.mapper.pedido.PagamentoMapper;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoResponseDTO;
import org.purpura.apipg.model.pedido.pagamento.PagamentoModel;
import org.purpura.apipg.repository.pedido.pagamento.PagamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoService {
    private final PagamentoMapper pagamentoMapper;
    private final PagamentoRepository pagamentoRepository;

    private PagamentoModel findById(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new PagamentoNotFoundException(id));
    }

    public PagamentoResponseDTO findByIdResponse(Long id) {
        return pagamentoMapper.toResponse(findById(id));
    }

    public List<PagamentoResponseDTO> findAllByIdPedido(Long idPedido) {
        return pagamentoMapper.toResponseList(pagamentoRepository.findAllByPedidoIdPedido(idPedido));
    }

    private PagamentoResponseDTO save(PagamentoModel pagamentoModel) {
        return pagamentoMapper.toResponse(pagamentoRepository.save(pagamentoModel));
    }

    @Transactional
    public PagamentoResponseDTO save(PagamentoRequestDTO pagamentoRequestDTO) {
        return save(pagamentoMapper.toModel(pagamentoRequestDTO));
    }

    /**
     * Será implementado posteriormente.
     * @param ignoredPagamentoId Id do pagamento que será concluído.
     * @return PagamentoResponseDTO
     */
    public PagamentoResponseDTO concluir(Long ignoredPagamentoId) {
        throw new UnsupportedOperationException("Método não implementado ainda.");
    }

    public PagamentoResponseDTO cancelar(Long pagamentoId) {
        PagamentoModel pagamento = findById(pagamentoId);
        pagamento.cancelar();
        return save(pagamento);
    }
}
