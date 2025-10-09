package org.purpura.apipg.controller.pedido.pagamento.oas;

import jakarta.validation.Valid;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
public interface PagamentoContract {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PagamentoResponseDTO save(@Valid @RequestBody PagamentoRequestDTO pagamentoRequestDTO);

    @GetMapping("/{pagamentoId}")
    @ResponseStatus(HttpStatus.OK)
    PagamentoResponseDTO getById(@PathVariable Long pagamentoId);

    @GetMapping("/pedido/{pedidoId}/all")
    @ResponseStatus(HttpStatus.OK)
    List<PagamentoResponseDTO> findAllByPedidoId(@PathVariable Long pedidoId);

    @PatchMapping("/{pagamentoId}/concluir")
    @ResponseStatus(HttpStatus.OK)
    PagamentoResponseDTO concluir(@PathVariable Long pagamentoId);

    @PatchMapping("/{pagamentoId}/cancelar")
    @ResponseStatus(HttpStatus.OK)
    PagamentoResponseDTO cancelar(@PathVariable Long pagamentoId);
}
