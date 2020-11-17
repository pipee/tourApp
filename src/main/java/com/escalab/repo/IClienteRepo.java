package com.escalab.repo;

import com.escalab.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

    @Query("from Cliente c where LOWER(c.nombres) like %:nombre% or LOWER(c.apellidos) like %:nombre% ")
    Cliente buscarPorNombreCliente(@Param("nombre") String nombre);
}
