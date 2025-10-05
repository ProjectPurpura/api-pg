package org.purpura.apipg.controller.pedido.oas;

import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CNPJ;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
public interface PedidoContract {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PedidoResponseDTO getPedidoById(@PathVariable Long id);

    @GetMapping("/vendas/{entregador}")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResponseDTO> getAllByEntregador(@Valid @CNPJ @PathVariable String entregador);

    @GetMapping("/compras/{recebedor}")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResponseDTO> getAllByRecebedor(@Valid @CNPJ @PathVariable String recebedor);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResponseDTO> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PedidoResponseDTO save(@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PedidoResponseDTO update(@PathVariable Long id, @RequestBody @Valid PedidoRequestDTO pedidoRequestDTO);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Long id);

}
