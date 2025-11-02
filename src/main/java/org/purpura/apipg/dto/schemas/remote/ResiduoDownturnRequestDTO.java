package org.purpura.apipg.dto.schemas.remote;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Objeto de Transferência de Dados para requisições enviadas a APIs externas para reduzir o estoque de resíduos.
 * Para evitar latência fazendo as requisições em lote.
 * <p>Contém uma lista de entradas de redução de estoque descrevendo as alterações de quantidade
 * para um ou mais resíduos.</p>
 *
 * <p>Anotações Swagger/OpenAPI não são necessárias para este DTO.</p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResiduoDownturnRequestDTO {
    private List<EstoqueDownturn> estoqueDownturns;
}
