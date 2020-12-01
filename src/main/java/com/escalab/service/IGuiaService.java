package com.escalab.service;

import com.escalab.dto.FiltroDTO;
import com.escalab.model.Guia;

import java.util.List;

public interface IGuiaService extends ICRUD<Guia> {

    List<Guia> buscarGuiaPorNombre(FiltroDTO filtro);
}
