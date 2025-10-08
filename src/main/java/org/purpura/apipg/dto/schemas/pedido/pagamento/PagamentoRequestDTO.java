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
@Schema(name = "PagamentoRequestDTO", description = "DTO para a inserção/atualização de um pagamento")
public class PagamentoRequestDTO {
    @Schema(description = "ID do pedido relativo ao pagamento", example = "1")
    private Long idPedido;

    @Schema(description = "Valor do pagamento", example = "100.00")
    private Double valorPago;

    @Schema(description = "Tipo de pagamento", example = "pix")
    private PagamentoTipo tipo;
}
