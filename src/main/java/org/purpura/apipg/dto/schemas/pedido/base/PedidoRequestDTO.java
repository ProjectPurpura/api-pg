package org.purpura.apipg.dto.schemas.pedido.base;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.purpura.apipg.model.pedido.PedidoStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "PedidoRequestDTO", description = "DTO para a inserção/atualização de um pedido")
public class PedidoRequestDTO {
    @Schema(description = "ID do vendedor (CNPJ). Em suma, de quem foi comprado / quem vendeu?", example = "12345678000195")
    @CNPJ(message = "O id do vendedor deve ser um CNPJ válido.")
    @NotNull(message = "O id do vendedor deve ser informado e não nulo.")
    @NotBlank(message = "O id do vendedor deve ser informado e não nulo.")
    private String idVendedor;

    @Schema(description = "ID do comprador (CNPJ). Em suma, Quem comprou?", example = "98765432000109")
    @CNPJ(message = "O id do comprador deve ser um CNPJ válido.")
    @NotNull(message = "O id do comprador deve ser informado e não nulo.")
    @NotBlank(message = "O id do comprador deve ser informado e não nulo.")
    private String idComprador;

    @Schema(description = "Data do pedido (timestamp)", example = "1627702400000")
    @Builder.Default
    private Long data = System.currentTimeMillis();

    @Schema(description = "Status do pedido", example = "PENDENTE")
    @Builder.Default
    private PedidoStatus status = PedidoStatus.PENDENTE;

    @Schema(description = "Data de agendamento da coleta (timestamp)", example = "1627702400000")
    @Builder.Default
    private Long agendamentoColeta = null;

}
