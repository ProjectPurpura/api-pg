package org.purpura.apipg.controller.noticia.oas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.purpura.apipg.dto.schemas.noticia.NoticiaResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


public interface NoticiaContract {
    @Operation(summary = "Obtém uma lista de notícias", description = "Retorna uma lista de notícias",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de notícias retornada com sucesso",
                content = @Content(schema = @Schema(implementation = NoticiaResponseDTO.class, type = "array"))
            )
        }
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<NoticiaResponseDTO> getNoticias();
}
