package org.purpura.apipg.model.pedido;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "residuoPedido")
public class ResiduoPedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResiduoPedido;

    @Column(nullable = false, length = 50)
    private String fkResiduo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkPedido", referencedColumnName = "idPedido", nullable = false)
    private PedidoModel pedido;
}

