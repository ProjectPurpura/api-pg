package org.purpura.apipg.dto.schemas.pedido.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.purpura.apipg.model.pedido.meta.PedidoStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "PedidoResponseDTO", description = "Representa um DTO de resposta a um pedido retornado da API")
public class PedidoResponseDTO {
    @Schema(description = "ID do pedido", example = "1")
    private Long idPedido;

    @Schema(description = "ID do vendedor (CNPJ)", example = "12345678000195")
    private String idVendedor;

    @Schema(description = "ID do comprador (CNPJ)", example = "98765432000109")
    private String idComprador;

    @Schema(description = "Data do pedido (timestamp)", example = "2023-10-06T12:00:00")
    private LocalDateTime data;

    @Schema(description = "Status do pedido (aberto, aprovado, concluído, cancelado)", example = "aberto")
    private PedidoStatus status;

    @Schema(description = "Data de agendamento da coleta (timestamp)", example = "2023-10-06T12:00:00")
    private LocalDateTime agendamentoColeta;

    @Schema(description = "Valor total do pedido")
    private Double valorTotal;

    @Schema(description = "Observações adicionais sobre o pedido", example = "Por favor, entregar perto da saída avisando o porteiro.")
    private String observacoes;
}
