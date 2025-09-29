package org.purpura.apipg.model.pedido;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    Long idPedido;

    @Builder.Default
    long data = System.currentTimeMillis();

    LocalDate agendamentoColeta;

    @Enumerated(EnumType.STRING)
    PedidoStatus status;

    @Builder.Default
    String observacoes = "";
    Double valorTotal;

    String fkRecebedor;
    String fkEntregador;
}
