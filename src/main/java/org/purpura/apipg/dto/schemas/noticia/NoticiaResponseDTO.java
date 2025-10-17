package org.purpura.apipg.dto.schemas.noticia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "NoticiaResponseDTO", description = "Representa uma noticia")
public class NoticiaResponseDTO {
    @Schema(description = "ID da noticia", example = "1")
    private Integer id;

    @Schema(description = "Titulo da noticia", example = "Titulo da noticia")
    private String titulo;

    @Schema(description = "Link da noticia", example = "https://www.noticia.com/noticia")
    private String link;

    @Schema(description = "URL da imagem da noticia", example = "https://www.noticia.com/noticia.jpg")
    private String urlImagem;

}
