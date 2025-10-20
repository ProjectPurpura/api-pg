package org.purpura.apipg.model.pedido.relatorio;

import jakarta.persistence.*;
import lombok.*;
import org.purpura.apipg.model.pedido.PedidoModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedidorelatorio", uniqueConstraints = @UniqueConstraint(columnNames = {"fkRelatorio", "fkPedido"}))
public class PedidoRelatorioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoRelatorio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkpedido", referencedColumnName = "idrelatorio", nullable = false)
    private RelatorioModel relatorio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkpedido", referencedColumnName = "idpedido", nullable = false)
    private PedidoModel pedido;
}

