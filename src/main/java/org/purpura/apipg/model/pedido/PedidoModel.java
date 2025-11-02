package org.purpura.apipg.model.pedido;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.purpura.apipg.model.pedido.meta.state.PedidoState;
import org.purpura.apipg.model.pedido.meta.PedidoStatus;
import org.purpura.apipg.model.pedido.pagamento.PagamentoModel;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    @Column(name="idpedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @Column(name="agendamentocoleta")
    private LocalDateTime agendamentoColeta;

    @Column(name="fkrecebedor", nullable = false)
    private String idComprador;

    @Column(name="fkentregador", nullable = false)
    private String idVendedor;

    @Builder.Default
    private LocalDateTime data = LocalDateTime.now();

    @Builder.Default
    private Double valorTotal = 0.0;

    @Builder.Default
    private String observacoes = "";

    @Builder.Default
    @Convert(converter = PedidoStatus.Convert.class)
    private PedidoStatus status = PedidoStatus.ABERTO;

    @Transient
    private transient PedidoState state;

    public PedidoState getState() {
        return new PedidoStatus.Adapter(status).toState();
    }

    public void aprovar() {
        this.state = getState().aprovar();
        this.status = state.getStatus();
    }

    public void cancelar() {
        this.state = getState().cancelar();
        this.status = state.getStatus();
    }

    public void concluir() {
        this.state = getState().concluir();
        this.status = state.getStatus();
    }
}
