package org.purpura.apipg.model.pedido.transporte;

import jakarta.persistence.*;
import lombok.*;
import org.purpura.apipg.model.pedido.PedidoModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transporte")
public class TransporteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransporte;

    @Column(nullable = false, length = 255)
    private String transportadora;

    @Column(nullable = false)
    private LocalDate dataRetirada;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkPedido", referencedColumnName = "idPedido", nullable = false)
    private PedidoModel pedido;
}

