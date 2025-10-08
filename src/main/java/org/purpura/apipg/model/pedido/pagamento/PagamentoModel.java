package org.purpura.apipg.model.pedido.pagamento;

import jakarta.persistence.*;
import lombok.*;
import org.purpura.apipg.model.pedido.PedidoModel;

import java.math.BigDecimal;
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
    @Column(name = "idpagamento")
    private Long idPagamento;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime data = LocalDateTime.now();

    @Column(name = "valorpago",nullable = false, precision = 12, scale = 2)
    private BigDecimal valorPago;

    @Builder.Default
    @Column(nullable = false, length = 50)
    @Convert(converter = PagamentoTipo.Converter.class)
    private PagamentoTipo tipo = PagamentoTipo.PIX;

    @Builder.Default
    @Column(nullable = false, length = 50)
    @Convert(converter = PagamentoStatus.Converter.class)
    private PagamentoStatus status = PagamentoStatus.PENDENTE;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkpedido", referencedColumnName = "idpedido", nullable = false)
    private PedidoModel pedido;
}