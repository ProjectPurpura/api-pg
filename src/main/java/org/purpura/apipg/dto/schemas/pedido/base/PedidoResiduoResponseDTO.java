package org.purpura.apipg.dto.schemas.pedido.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO que representa a resposta de um item do pedido.")
public class PedidoResiduoResponseDTO {
    @Schema(description = "ID do item", example = "1")
    private Long id;

    @Schema(description = "ID do resído do MongoDB (UUID)", example = "67890123-4567-8901-2345-678901234567")
    private String idResiduo;

    @Schema(description = "Preço do item quando foi adicionado / comprado", example = "10.00")
    private Double preco;

    @Schema(description = "Quantidade do item", example = "10")
    private Integer quantidade;

    @Schema(description = "Peso do item", example = "6.00")
    private Double peso;

    @Schema(description = "Tipo de unidade", example = "KG")
    private String tipoUnidade;

}
