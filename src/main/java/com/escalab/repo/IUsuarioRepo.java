package com.escalab.repo;

import com.escalab.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

    @Query("from Usuario us where us.username = :username")
    Usuario bucarPorUsername(@Param("username") String username);
}
