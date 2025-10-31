package org.purpura.apipg.dto.schemas.remote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa um objeto para a alteração de estoque de um resíduo.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoqueDownturn {
    private String idResiduo;
    private Integer quantidade;
}
