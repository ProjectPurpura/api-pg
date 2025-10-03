package org.purpura.apipg.dto.schemas.pedido.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.purpura.apipg.model.pedido.PedidoStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "PedidoResponseDTO", description = "Representa um DTO de resposta a um pedido retornado da API")
public class PedidoResponseDTO {
    @Schema(description = "ID do pedido", example = "1")
    private Long id;

    @Schema(description = "Data de agendamento da coleta (timestamp)", example = "1627702400000")
    private Long agendamentoColeta;

    @Schema(description = "Data do pedido (timestamp)", example = "1627702400000")
    private Long data = System.currentTimeMillis();

    @Schema(description = "Status do pedido", example = "PENDENTE")
    private PedidoStatus status;
}
