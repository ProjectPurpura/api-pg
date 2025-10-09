package org.purpura.apipg.controller.pedido.pagamento;

import lombok.RequiredArgsConstructor;
import org.purpura.apipg.controller.pedido.pagamento.oas.PagamentoContract;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoResponseDTO;
import org.purpura.apipg.service.pedido.pagamento.PagamentoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
@RequiredArgsConstructor
public class PagamentoController implements PagamentoContract {
    private final PagamentoService pagamentoService;

    @Override
    public PagamentoResponseDTO save(@RequestBody PagamentoRequestDTO pagamentoRequestDTO) {
        return pagamentoService.save(pagamentoRequestDTO);
    }

    @Override
    public PagamentoResponseDTO getById(Long pagamentoId) {
        return pagamentoService.findByIdResponse(pagamentoId);
    }

    @Override
    public List<PagamentoResponseDTO> findAllByPedidoId(Long pedidoId) {
        return pagamentoService.findAllByIdPedido(pedidoId);
    }

    @Override
    public PagamentoResponseDTO concluir(Long pagamentoId) {
        return pagamentoService.concluir(pagamentoId);
    }

    @Override
    public PagamentoResponseDTO cancelar(Long pagamentoId) {
        return pagamentoService.cancelar(pagamentoId);
    }
}
