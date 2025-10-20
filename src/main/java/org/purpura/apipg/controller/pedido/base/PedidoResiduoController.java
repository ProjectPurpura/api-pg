package org.purpura.apipg.controller.pedido.base;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.purpura.apipg.controller.pedido.base.oas.PedidoResiduoContract;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoResponseDTO;
import org.purpura.apipg.service.pedido.base.PedidoResiduoService;
import org.purpura.apipg.service.pedido.base.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido/{pedidoId}/residuo")
@RequiredArgsConstructor
public class PedidoResiduoController implements PedidoResiduoContract {

    private final PedidoResiduoService pedidoResiduoService;
    private final PedidoService pedidoService;

    @Override
    public PedidoResiduoResponseDTO addResiduo(
            @PathVariable Long pedidoId,
            @RequestBody PedidoResiduoRequestDTO pedidoResiduoRequestDTO
    ) {
        return pedidoService.addResiduo(pedidoId, pedidoResiduoRequestDTO);
    }

    @Override
    public List<PedidoResiduoResponseDTO> getResiduos(@PathVariable Long pedidoId) {
        return pedidoResiduoService.getResiduosByPedido(pedidoId);
    }

    @Override
    public PedidoResiduoResponseDTO updateResiduo(
            Long pedidoId,
            Long residuoId,
            @RequestBody PedidoResiduoRequestDTO pedidoResiduoRequestDTO
    ) {
        return pedidoService.updateResiduo(pedidoId, residuoId, pedidoResiduoRequestDTO);
    }

    @Override
    public void deleteResiduo(Long pedidoId, Long residuoId) {
        pedidoService.deleteResiduo(pedidoId, residuoId);
    }


}
