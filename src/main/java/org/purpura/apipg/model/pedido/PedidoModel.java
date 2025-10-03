package org.purpura.apipg.model.pedido;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.purpura.apipg.model.pedido.state.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    Long idPedido;

    Long agendamentoColeta;


    @Column(name="fk_recebedor")
    String idRecebedor;

    @Column(name="fk_entregador")
    String idEntregador;

    @Builder.Default
    Long data = System.currentTimeMillis();

    @Builder.Default
    Double valorTotal = 0.0;

    @Builder.Default
    String observacoes = "";

    @Enumerated(EnumType.STRING)
    PedidoStatus status;

    @Transient
    private transient PedidoState state;

    public PedidoState getState() {
        if (state == null) {
            switch (status) {
                case PENDENTE -> state = new PendenteState();
                case APROVADO -> state = new AprovadoState();
                case CONCLUIDO -> state = new ConcluidoState();
                case CANCELADO -> state = new CanceladoState();
            }
        }
        return state;
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
