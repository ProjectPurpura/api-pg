package org.purpura.apipg.controller.pedido;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoResponseDTO;
import org.purpura.apipg.service.pedido.PedidoResiduoService;
import org.purpura.apipg.service.pedido.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido/{pedidoId}/residuo")
@RequiredArgsConstructor
public class PedidoResiduoController {

    private final PedidoResiduoService pedidoResiduoService;
    private final PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResiduoResponseDTO addResiduo(
            @PathVariable Long pedidoId,
            @RequestBody @Valid
            PedidoResiduoRequestDTO pedidoResiduoRequestDTO
    ) {
        return pedidoService.addResiduo(pedidoId, pedidoResiduoRequestDTO);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoResiduoResponseDTO> getResiduos(@PathVariable Long pedidoId) {
        return pedidoResiduoService.getResiduosByPedido(pedidoId);
    }
}
