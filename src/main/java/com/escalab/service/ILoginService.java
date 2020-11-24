package com.escalab.service;

import com.escalab.model.Usuario;

public interface ILoginService {

    Usuario validarUsername(String usuario) throws Exception;
    int cambiarClave(String clave, String nombre) throws Exception;
}
