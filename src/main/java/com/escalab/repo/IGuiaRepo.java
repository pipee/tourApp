package com.escalab.repo;

import com.escalab.model.Guia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGuiaRepo extends JpaRepository<Guia, Integer> {

    @Query("from Guia g where LOWER(g.nombres) like %:nombre% or LOWER(g.apellidos) like %:nombre%")
    List<Guia> buscarPorNombreGuia(@Param("nombre") String nombre);
}
