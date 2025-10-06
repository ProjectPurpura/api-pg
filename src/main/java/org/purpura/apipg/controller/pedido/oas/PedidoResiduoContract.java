package org.purpura.apipg.controller.pedido.oas;

import jakarta.validation.Valid;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
public interface PedidoResiduoContract {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PedidoResiduoResponseDTO addResiduo(
            Long pedidoId,
            @RequestBody @Valid
            PedidoResiduoRequestDTO pedidoResiduoRequestDTO
    );

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResiduoResponseDTO> getResiduos(Long pedidoId);
}
