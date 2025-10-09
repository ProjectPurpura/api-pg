package org.purpura.apipg.controller.pedido.base.oas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
        summary = "Buscar pedido por ID",
        description = "Retorna os detalhes de um pedido pelo seu ID.",
        parameters = {
            @Parameter(name = "id", description = "ID do pedido", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado", content = @Content(schema = @Schema(implementation = PedidoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PedidoResponseDTO getPedidoById(@PathVariable Long id);

    @Operation(
        summary = "Listar vendas por vendedor",
        description = "Retorna todos os pedidos de venda de um vendedor.",
        parameters = {
            @Parameter(name = "vendedorId", description = "CNPJ do vendedor", example = "12.345.678/0001-99")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de vendas", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PedidoResponseDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Vendedor não encontrado")
        }
    )
    @GetMapping("/vendas/{vendedorId}")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResponseDTO> getAllByVendedorId(@Valid @CNPJ @PathVariable String vendedorId);

    @Operation(
        summary = "Listar compras por comprador",
        description = "Retorna todos os pedidos de compra de um comprador.",
        parameters = {
            @Parameter(name = "compradorId", description = "CNPJ do comprador", example = "98.765.432/0001-11")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de compras", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PedidoResponseDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Comprador não encontrado")
        }
    )
    @GetMapping("/compras/{compradorId}")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResponseDTO> getAllByCompradorId(@Valid @CNPJ @PathVariable String compradorId);

    @Operation(
        summary = "Listar todos os pedidos",
        description = "Retorna todos os pedidos cadastrados.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de pedidos", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PedidoResponseDTO.class))))
        }
    )
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResponseDTO> getAll();

    @Operation(
        summary = "Criar novo pedido",
        description = "Cria um novo pedido e retorna o pedido criado.",
        requestBody = @RequestBody(
            description = "Dados para criação do pedido",
            required = true,
            content = @Content(schema = @Schema(implementation = PedidoRequestDTO.class))
        ),
        responses = {
            @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso", content = @Content(schema = @Schema(implementation = PedidoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
        }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PedidoResponseDTO save(@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO);

    @Operation(
        summary = "Atualizar pedido",
        description = "Atualiza um pedido existente.",
        parameters = {
            @Parameter(name = "id", description = "ID do pedido", example = "1")
        },
        requestBody = @RequestBody(
            description = "Dados para atualização do pedido",
            required = true,
            content = @Content(schema = @Schema(implementation = PedidoRequestDTO.class))
        ),
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso", content = @Content(schema = @Schema(implementation = PedidoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Deprecated
    PedidoResponseDTO update(@PathVariable Long id, @RequestBody @Valid PedidoRequestDTO pedidoRequestDTO);

    @Operation(
        summary = "Excluir pedido",
        description = "Exclui um pedido pelo ID.",
        parameters = {
            @Parameter(name = "id", description = "ID do pedido", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "204", description = "Pedido excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Long id);

    @Operation(
        summary = "Aprovar pedido",
        description = "Aprova o pedido informado.",
        parameters = {
            @Parameter(name = "id", description = "ID do pedido", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido aprovado", content = @Content(schema = @Schema(implementation = PedidoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @PatchMapping("/{id}/aprovar")
    @ResponseStatus(HttpStatus.OK)
    PedidoResponseDTO aprovar(@PathVariable Long id);

    @Operation(
        summary = "Concluir pedido",
        description = "Marca o pedido como concluído.",
        parameters = {
            @Parameter(name = "id", description = "ID do pedido", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido concluído", content = @Content(schema = @Schema(implementation = PedidoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @PatchMapping("/{id}/concluir")
    @ResponseStatus(HttpStatus.OK)
    PedidoResponseDTO concluir(@PathVariable Long id);

    @Operation(
        summary = "Cancelar pedido",
        description = "Cancela o pedido informado.",
        parameters = {
            @Parameter(name = "id", description = "ID do pedido", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido cancelado", content = @Content(schema = @Schema(implementation = PedidoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @PatchMapping("/{id}/cancelar")
    @ResponseStatus(HttpStatus.OK)
    PedidoResponseDTO cancelar(@PathVariable Long id);

}
