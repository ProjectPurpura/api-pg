package org.purpura.apipg.model.pedido;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "residuopedido")
public class PedidoResiduoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResiduoPedido;

    @Column(name = "fkresiduo", nullable = false, length = 50)
    private String idResiduo;
    
    private String tipoUnidade;
    private Double preco;
    private Double peso;
    private Integer quantidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkpedido", referencedColumnName = "idpedido", nullable = false)
    private PedidoModel pedido;

}

