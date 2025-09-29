package org.purpura.apipg.model.pedido.pagamento;

import jakarta.persistence.*;
import lombok.*;
import org.purpura.apipg.model.pedido.PedidoModel;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pagamento")
public class PagamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime data = LocalDateTime.now();

    @Column(nullable = false, precision = 12, scale = 2)
    private Double valorPago;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    @Builder.Default
    private PagamentoTipo tipo = PagamentoTipo.PIX;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    @Builder.Default
    private PagamentoStatus status = PagamentoStatus.PENDENTE;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkPedido", referencedColumnName = "idPedido", nullable = false)
    private PedidoModel pedido;
}