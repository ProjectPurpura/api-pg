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
    private Long idRelatorio;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime emissao = LocalDateTime.now();

    @Column(nullable = false, length = 50)
    private String tipoRelatorio;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String conteudo;
}

