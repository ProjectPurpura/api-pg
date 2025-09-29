package org.purpura.apipg.service.noticia;

import org.purpura.apipg.model.noticia.NoticiaModel;
import org.purpura.apipg.repository.noticia.NoticiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {
    private final NoticiaRepository noticiaRepository;

    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    public List<NoticiaModel> getNoticias() {
        return noticiaRepository.getNoticias();
    }
}