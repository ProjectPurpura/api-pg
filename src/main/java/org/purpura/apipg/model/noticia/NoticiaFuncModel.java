package org.purpura.apipg.model.noticia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticiaFuncModel {
    private Integer idnoticia;
    private String titulo;
    private String link;
    private String imagem;
}
