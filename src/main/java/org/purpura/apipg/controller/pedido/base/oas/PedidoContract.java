package org.purpura.apipg.controller.pedido.base.oas;

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

    @GetMapping("/vendas/{vendedorId}")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResponseDTO> getAllByVendedorId(@Valid @CNPJ @PathVariable String vendedorId);

    @GetMapping("/compras/{compradorId}")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResponseDTO> getAllByCompradorId(@Valid @CNPJ @PathVariable String compradorId);

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResponseDTO> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PedidoResponseDTO save(@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Deprecated
    PedidoResponseDTO update(@PathVariable Long id, @RequestBody @Valid PedidoRequestDTO pedidoRequestDTO);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Long id);

    @PatchMapping("/{id}/aprovar")
    @ResponseStatus(HttpStatus.OK)
    PedidoResponseDTO aprovar(@PathVariable Long id);

    @PatchMapping("/{id}/concluir")
    @ResponseStatus(HttpStatus.OK)
    PedidoResponseDTO concluir(@PathVariable Long id);

    @PatchMapping("/{id}/cancelar")
    @ResponseStatus(HttpStatus.OK)
    PedidoResponseDTO cancelar(@PathVariable Long id);

}
