package com.escalab.repo;

import com.escalab.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ILoginRepo extends JpaRepository<Usuario, Integer> {

    @Query("FROM Usuario u where us.username = :username")
    Usuario validarUsername(@Param("username") String username) throws Exception;

    @Modifying
    @Query("UPDATE Usuario u SET u.password = :pass WHERE u.username = :username")
    void cambiarClave(@Param("pass") String pass, @Param("username") String username) throws Exception;
}
