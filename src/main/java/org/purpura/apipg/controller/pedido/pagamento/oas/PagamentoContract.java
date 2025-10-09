package org.purpura.apipg.controller.pedido.pagamento.oas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.pagamento.PagamentoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
public interface PagamentoContract {
    @Operation(
        summary = "Criar novo pagamento",
        description = "Cria um novo pagamento para um pedido. Retorna o pagamento criado.",
        requestBody = @RequestBody(
            description = "Dados para criação do pagamento",
            required = true,
            content = @Content(
                schema = @Schema(implementation = PagamentoRequestDTO.class),
                examples = {}
            )
        ),
        responses = {
            @ApiResponse(responseCode = "201", description = "Pagamento criado com sucesso", content = @Content(schema = @Schema(implementation = PagamentoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PagamentoResponseDTO save(@Valid @RequestBody PagamentoRequestDTO pagamentoRequestDTO);

    @Operation(
        summary = "Buscar pagamento por ID",
        description = "Retorna os detalhes de um pagamento pelo seu ID.",
        parameters = {
            @Parameter(name = "pagamentoId", description = "ID do pagamento", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pagamento encontrado", content = @Content(schema = @Schema(implementation = PagamentoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
        }
    )
    @GetMapping("/{pagamentoId}")
    @ResponseStatus(HttpStatus.OK)
    PagamentoResponseDTO getById(@PathVariable Long pagamentoId);

    @Operation(
        summary = "Listar pagamentos de um pedido",
        description = "Retorna todos os pagamentos associados a um pedido.",
        parameters = {
            @Parameter(name = "pedidoId", description = "ID do pedido", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de pagamentos", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PagamentoResponseDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @GetMapping("/pedido/{pedidoId}/all")
    @ResponseStatus(HttpStatus.OK)
    List<PagamentoResponseDTO> findAllByPedidoId(@PathVariable Long pedidoId);

    @Operation(
        summary = "Concluir pagamento",
        description = "Marca o pagamento como concluído.",
        parameters = {
            @Parameter(name = "pagamentoId", description = "ID do pagamento", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pagamento concluído", content = @Content(schema = @Schema(implementation = PagamentoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
        }
    )
    @PatchMapping("/{pagamentoId}/concluir")
    @ResponseStatus(HttpStatus.OK)
    PagamentoResponseDTO concluir(@PathVariable Long pagamentoId);

    @Operation(
        summary = "Cancelar pagamento",
        description = "Cancela o pagamento informado.",
        parameters = {
            @Parameter(name = "pagamentoId", description = "ID do pagamento", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pagamento cancelado", content = @Content(schema = @Schema(implementation = PagamentoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
        }
    )
    @PatchMapping("/{pagamentoId}/cancelar")
    @ResponseStatus(HttpStatus.OK)
    PagamentoResponseDTO cancelar(@PathVariable Long pagamentoId);
}
