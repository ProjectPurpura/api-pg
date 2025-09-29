package org.purpura.apipg.dto.mapper.noticia;


import org.purpura.apipg.dto.mapper.base.BeanUtilMapper;
import org.purpura.apipg.dto.schemas.noticia.NoticiaResponseDTO;
import org.purpura.apipg.model.noticia.NoticiaModel;
import org.springframework.stereotype.Component;

@Component
public class NoticiaMapper extends BeanUtilMapper<NoticiaModel, Object, NoticiaResponseDTO> {

    public NoticiaMapper() {
        super(NoticiaModel.class, NoticiaResponseDTO.class);
    }
}
