package org.purpura.apipg.repository.noticia;

import org.purpura.apipg.model.noticia.NoticiaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<NoticiaModel, Long> {
    @Query(name = "SELECT * FROM func_mostrar_noticias()", nativeQuery = true)
    List<NoticiaModel> getNoticias();
}
