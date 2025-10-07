package org.purpura.apipg.service.noticia;

import lombok.RequiredArgsConstructor;
import org.purpura.apipg.model.noticia.NoticiaFuncModel;
import org.purpura.apipg.repository.noticia.NoticiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticiaService {
    private final NoticiaRepository noticiaRepository;

    public List<NoticiaFuncModel> getNoticias() {
        return noticiaRepository.getNoticiasFromFunction();
    }
}