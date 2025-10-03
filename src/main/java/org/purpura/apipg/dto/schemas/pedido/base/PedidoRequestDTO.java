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
@Schema(name = "PedidoRequestDTO", description = "DTO para a inserção/atualização de um pedido")
public class PedidoRequestDTO {
    @Schema(description = "Data de agendamento da coleta (timestamp)", example = "1627702400000")
    @Builder.Default
    private Long agendamentoColeta = null;

    @Schema(description = "Data do pedido (timestamp)", example = "1627702400000")
    @Builder.Default
    private Long data = System.currentTimeMillis();

    @Schema(description = "Status do pedido", example = "PENDENTE")
    @Builder.Default
    private PedidoStatus status = PedidoStatus.PENDENTE;
}
