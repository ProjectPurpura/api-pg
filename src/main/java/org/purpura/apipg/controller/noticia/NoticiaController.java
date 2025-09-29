package org.purpura.apipg.controller.noticia;

import org.purpura.apipg.controller.noticia.oas.NoticiaContract;
import org.purpura.apipg.dto.mapper.noticia.NoticiaMapper;
import org.purpura.apipg.dto.schemas.noticia.NoticiaResponseDTO;
import org.purpura.apipg.service.noticia.NoticiaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/noticia")
public class NoticiaController implements NoticiaContract {
    private final NoticiaService noticiaService;
    private final NoticiaMapper noticiaMapper;

    public NoticiaController(NoticiaService noticiaService, NoticiaMapper noticiaMapper) {
        this.noticiaService = noticiaService;
        this.noticiaMapper = noticiaMapper;
    }

    @Override
    public List<NoticiaResponseDTO> getNoticias() {
        return noticiaMapper.toResponseList(noticiaService.getNoticias());
    }
}
