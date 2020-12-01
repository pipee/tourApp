package com.escalab.service;

import com.escalab.model.Menu;

import java.util.List;

public interface IMenuService extends ICRUD<Menu> {

    List<Menu> listarMenuPorUsuario(String nombre);
}
