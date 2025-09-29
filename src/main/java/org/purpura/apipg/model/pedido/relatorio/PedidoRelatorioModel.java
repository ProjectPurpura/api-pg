package org.purpura.apipg.model.pedido.relatorio;

import jakarta.persistence.*;
import lombok.*;
import org.purpura.apipg.model.pedido.PedidoModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedidoRelatorio", uniqueConstraints = @UniqueConstraint(columnNames = {"fkRelatorio", "fkPedido"}))
public class PedidoRelatorioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoRelatorio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkRelatorio", referencedColumnName = "idRelatorio", nullable = false)
    private RelatorioModel relatorio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkPedido", referencedColumnName = "idPedido", nullable = false)
    private PedidoModel pedido;
}

