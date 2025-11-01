package org.purpura.apipg.dto.schemas.pedido.base;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO para criação/alteração de um item do pedido.")
public class PedidoResiduoRequestDTO {

    @Schema(description = "ID do resído do MongoDB (UUID)", example = "67890123-4567-8901-2345-678901234567")
    @NotNull(message = "O id do resíduo relativo a esse item deve ser informado e não nulo")
    @NotBlank(message = "O id do resíduo relativo a esse item deve ser informado e não nulo")
    private String idResiduo;

    @Schema(description = "Nome do resíduo")
    @NotNull(message = "O nome do resíduo relativo a esse item deve ser informado e não nulo")
    @NotBlank(message = "O nome do resíduo relativo a esse item deve ser informado e não nulo")
    private String nome;

    @Schema(description = "URL da foto do resíduo")
    @NotNull(message = "A URL da foto relativa a esse item deve ser informado e não nulo")
    @NotBlank(message = "O URL da foto relativa a esse item deve ser informado e não nulo")
    private String urlFoto;

    @Schema(description = "Preço do item quando foi adicionado / comprado", example = "10.00")
    @NotNull(message = "O preço de compra relativo a esse item deve ser informado e não nulo")
    private Double preco;

    @Schema(description = "Quantidade do item", example = "10")
    @NotNull(message = "A quantidade desse item deve ser informada e não nula")
    private Integer quantidade;

    @Schema(description = "Tipo de unidade", example = "KG")
    private String tipoUnidade;




    @Schema(description = """
Peso do item (opcional).
    * Quando informado, junto a quantidade o item ficará por exemplo:
         (quantidade) pacotes/caixas de (peso) em (tipoUnidade) de (nome)
    * Se não informado a representação fica:
         (quantidade) (tipoUnidade) de (nome)
""",
            example = "6.00")
    @Builder.Default
    private Double peso = null;


}
