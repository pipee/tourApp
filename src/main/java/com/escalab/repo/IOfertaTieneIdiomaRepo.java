package com.escalab.repo;

import com.escalab.model.OfertaTieneIdioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOfertaTieneIdiomaRepo extends JpaRepository<OfertaTieneIdioma, Integer> {

    @Modifying
    @Query(value = "INSERT INTO oferta_tiene_idioma(id_idioma, id_oferta) VALUES (:idIdioma, :idOferta)", nativeQuery = true)
    Integer registrar(@Param("idIdioma") Integer idIdioma, @Param("idOferta") Integer idOferta);

    @Query("from OfertaTieneIdioma oi where oi.ofertaTour.idOferta = :idOferta")
    List<OfertaTieneIdioma> listarIdiomasPorOferta(@Param("idOferta") Integer idOferta);
}
