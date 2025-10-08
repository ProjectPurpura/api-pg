package org.purpura.apipg.dto.schemas.pedido.pagamento;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.purpura.apipg.model.pedido.pagamento.PagamentoTipo;

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
    private Double valorPago;

    @Schema(description = "Tipo de pagamento", example = "pix")
    private PagamentoTipo tipo;

    @Schema(description = "Data do pagamento (timestamp)", example = "2023-10-06T12:00:00")
    private String data;
}
