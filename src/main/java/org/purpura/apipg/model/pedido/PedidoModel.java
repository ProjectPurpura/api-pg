package org.purpura.apipg.model.pedido;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.purpura.apipg.model.pedido.meta.state.PedidoState;
import org.purpura.apipg.model.pedido.meta.PedidoStatus;
import org.purpura.apipg.model.pedido.meta.PedidoStatusStateAdapter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPedido;

    Long agendamentoColeta;

    @Column(name="fk_recebedor", nullable = false)
    String idComprador;

    @Column(name="fk_entregador", nullable = false)
    String idVendedor;

    @Builder.Default
    Long data = System.currentTimeMillis();

    @Builder.Default
    Double valorTotal = 0.0;

    @Builder.Default
    String observacoes = "";

    @Enumerated(EnumType.STRING)
    @Builder.Default
    PedidoStatus status = PedidoStatus.PENDENTE;

    @Transient
    private transient PedidoState state;

    public PedidoState getState() {
        return new PedidoStatusStateAdapter(status).get();
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
