package org.purpura.apipg.model.pedido.relatorio;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "relatorio")
public class RelatorioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrelatorio")
    private Long idRelatorio;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime emissao = LocalDateTime.now();

    @Column(name="tiporelatorio", nullable = false, length = 50)
    @Builder.Default
    private String tipoRelatorio = "Selo Verde";
}

