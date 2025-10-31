package org.purpura.apipg.controller.pedido.base.oas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoRequestDTO;
import org.purpura.apipg.dto.schemas.pedido.base.PedidoResiduoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
public interface PedidoResiduoContract {
    @Operation(
        summary = "Adicionar resíduo ao pedido",
        description = "Adiciona um novo resíduo ao pedido informado.",
        parameters = {
            @Parameter(name = "pedidoId", description = "ID do pedido", example = "1")
        },
        requestBody = @RequestBody(
            description = "Dados para criação do resíduo",
            required = true,
            content = @Content(schema = @Schema(implementation = PedidoResiduoRequestDTO.class))
        ),
        responses = {
            @ApiResponse(responseCode = "201", description = "Resíduo adicionado com sucesso", content = @Content(schema = @Schema(implementation = PedidoResiduoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PedidoResiduoResponseDTO addResiduo(
            @PathVariable Long pedidoId,
            @RequestBody @Valid
            PedidoResiduoRequestDTO pedidoResiduoRequestDTO
    );

    @Operation(
        summary = "Listar resíduos do pedido",
        description = "Retorna todos os resíduos associados ao pedido informado.",
        parameters = {
            @Parameter(name = "pedidoId", description = "ID do pedido", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de resíduos", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PedidoResiduoResponseDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<PedidoResiduoResponseDTO> getResiduos(@PathVariable Long pedidoId);

    @Operation(
        summary = "Atualizar resíduo do pedido",
        description = "Atualiza um resíduo do pedido informado.",
        parameters = {
                @Parameter(name = "pedidoId", description = "ID do pedido", example = "1"),
                @Parameter(name = "residuoId", description = "ID do item do pedido", example = "10")
        },
        requestBody = @RequestBody(
            description = "Dados para atualização do resíduo",
            required = true,
            content = @Content(schema = @Schema(implementation = PedidoResiduoRequestDTO.class))
        ),
        responses = {
            @ApiResponse(responseCode = "200", description = "Resíduo atualizado com sucesso", content = @Content(schema = @Schema(implementation = PedidoResiduoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Pedido ou resíduo não encontrado")
        }
    )
    @PutMapping("/{pedidoResiduoId}")
    @ResponseStatus(HttpStatus.OK)
    PedidoResiduoResponseDTO updateResiduo(
            @PathVariable Long pedidoId,
            @PathVariable Long pedidoResiduoId,
            @RequestBody @Valid
            PedidoResiduoRequestDTO pedidoResiduoRequestDTO
    );

    @Operation(
        summary = "Excluir resíduo do pedido",
        description = "Exclui um resíduo do pedido informado.",
        parameters = {
            @Parameter(name = "pedidoId", description = "ID do pedido", example = "1"),
            @Parameter(name = "residuoId", description = "ID do item do pedido", example = "10")
        },
        responses = {
            @ApiResponse(responseCode = "204", description = "Resíduo excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido ou resíduo não encontrado")
        }
    )
    @DeleteMapping("/{pedidoResiduoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteResiduo(
            @PathVariable Long pedidoId,
            @PathVariable Long pedidoResiduoId
    );
}
