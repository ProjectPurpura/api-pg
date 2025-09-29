package org.purpura.apipg.dto.mapper.noticia;


import org.purpura.apipg.dto.mapper.base.BeanUtilMapper;
import org.purpura.apipg.dto.schemas.noticia.NoticiaResponseDTO;
import org.purpura.apipg.model.noticia.NoticiaFuncModel;
import org.springframework.stereotype.Component;

@Component
public class NoticiaMapper extends BeanUtilMapper<NoticiaFuncModel, Object, NoticiaResponseDTO> {

    public NoticiaMapper() {
        super(NoticiaFuncModel.class, NoticiaResponseDTO.class);
    }

    @Override
    public NoticiaResponseDTO toResponse(NoticiaFuncModel model) {
        return NoticiaResponseDTO.builder()
                .id(model.getIdnoticia())
                .link(model.getLink())
                .urlImagem(model.getImagem())
                .titulo(model.getTitulo())
                .build();
    }
}
