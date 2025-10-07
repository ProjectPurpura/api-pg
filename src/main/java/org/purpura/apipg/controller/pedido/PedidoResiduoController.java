package org.purpura.apipg.controller.pedido;

import lombok.RequiredArgsConstructor;
import org.purpura.apipg.controller.pedido.oas.PedidoResiduoContract;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoResponseDTO;
import org.purpura.apipg.service.pedido.PedidoResiduoService;
import org.purpura.apipg.service.pedido.PedidoService;
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
            PedidoResiduoRequestDTO pedidoResiduoRequestDTO
    ) {
        return pedidoService.addResiduo(pedidoId, pedidoResiduoRequestDTO);
    }

    @Override
    public List<PedidoResiduoResponseDTO> getResiduos(@PathVariable Long pedidoId) {
        return pedidoResiduoService.getResiduosByPedido(pedidoId);
    }
}
