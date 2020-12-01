package com.escalab.repo;

import com.escalab.model.OfertaTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOfertaTourRepo extends JpaRepository<OfertaTour, Integer> {

    @Query("from OfertaTour ot where LOWER(ot.guia.nombres) like %:nombre% or LOWER(ot.guia.apellidos) like %:nombre%")
    List<OfertaTour> listarTourPorNombreGuia(@Param("nombre") String nombre);

    @Query("from OfertaTour ot where ot.guia.id =:id")
    List<OfertaTour> listarTourPorIdGuia(@Param("id") Integer id);
}
