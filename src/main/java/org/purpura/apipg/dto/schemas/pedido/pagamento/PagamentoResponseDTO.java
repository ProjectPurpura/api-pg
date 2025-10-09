package org.purpura.apipg.dto.schemas.pedido.pagamento;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.purpura.apipg.model.pedido.pagamento.PagamentoTipo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "PagamentoResponseDTO", description = "Representa um DTO de resposta a um pagamento retornado da API")
public class PagamentoResponseDTO {
    @Schema(description = "ID do pagamento", example = "1")
    private Long idPagamento;

    @Schema(description = "ID do pedido", example = "1")
    private Long idPedido;

    @Schema(description = "Valor do pagamento", example = "100.00")
    private BigDecimal valorPago;

    @Schema(description = "Tipo de pagamento", example = "pix")
    private PagamentoTipo tipo;

    @Schema(description = "Data do pagamento (timestamp)", example = "2025-10-09T10:51:39.967347")
    private LocalDateTime data;
}
