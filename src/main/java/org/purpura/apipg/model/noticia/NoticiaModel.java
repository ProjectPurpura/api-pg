package org.purpura.apipg.model.noticia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "noticia")
public class NoticiaModel {
    @Id
    @Column(name="idnoticia")
    private Long idNoticia;

    private String titulo;

    private String link;

    @Column(name="imagem")
    private String urlImagem;
}
