package com.escalab.service.impl;

import com.escalab.model.Usuario;
import com.escalab.repo.ILoginRepo;
import com.escalab.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ILoginRepo repo;

    @Override
    public int cambiarClave(String clave, String nombre) {
        int respuesta = 0;
        try {
            repo.cambiarClave(clave, nombre);
            respuesta = 1;
        } catch (Exception e) {
            respuesta = 0;
        }
        return respuesta;
    }

    @Override
    public Usuario validarUsername(String usuario) {
        Usuario us = null;
        try {
            us = repo.validarUsername(usuario);
            us = us != null ? us : new Usuario();
        } catch (Exception e) {
            us = new Usuario();
        }
        return us;
    }
}
