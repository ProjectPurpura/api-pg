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
            @PathVariable Long pedidoId,
            @RequestBody @Valid
            PedidoResiduoRequestDTO pedidoResiduoRequestDTO
    );

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResiduoResponseDTO> getResiduos(@PathVariable Long pedidoId);

    @PutMapping("/{residuoId}")
    @ResponseStatus(HttpStatus.OK)
    PedidoResiduoResponseDTO updateResiduo(
            @PathVariable Long pedidoId,
            @PathVariable Long residuoId,
            @RequestBody @Valid
            PedidoResiduoRequestDTO pedidoResiduoRequestDTO
    );

    @DeleteMapping("/{residuoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteResiduo(
            @PathVariable Long pedidoId,
            @PathVariable Long residuoId
    );
}
