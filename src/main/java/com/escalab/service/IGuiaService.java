package com.escalab.service;

import com.escalab.model.Guia;

public interface IGuiaService extends ICRUD<Guia> {

    Guia buscarGuiaPorNombre(String nombre);
}
