package org.purpura.apipg.dto.schemas.pedido.pagamento;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.purpura.apipg.model.pedido.pagamento.PagamentoTipo;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "PagamentoRequestDTO", description = "DTO para a inserção/atualização de um pagamento")
public class PagamentoRequestDTO {
    @Schema(description = "ID do pedido relativo ao pagamento", example = "1")
    @NotNull(message = "O id do pedido deve ser informado e não nulo.")
    private Long idPedido;

    @Schema(description = "Valor do pagamento", example = "100.00")
    @NotNull(message = "O valor do pagamento deve ser informado e não nulo.")
    private BigDecimal valorPago;

    @Schema(description = "Tipo de pagamento", example = "pix")
    @NotNull(message = "O tipo do pagamento deve ser informado e não nulo.")
    private PagamentoTipo tipo;
}
