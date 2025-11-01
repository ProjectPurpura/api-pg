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
    @Column(name = "idresiduopedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fkresiduo", nullable = false)
    private String idResiduo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "urlfoto")
    private String urlFoto;

    @Column(name = "tipounidade")
    private String tipoUnidade;

    @Column(name = "precocomprado")
    private Double preco;

    @Column(name = "pesocomprado")
    private Double peso;

    @Column(name = "quantidaderesiduo")
    private Integer quantidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkpedido", referencedColumnName = "idpedido", nullable = false)
    private PedidoModel pedido;

}

