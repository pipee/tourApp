package com.escalab.service;


import com.escalab.model.Idioma;
import com.escalab.model.OfertaTieneIdioma;

import java.util.List;

public interface IOfertaTieneIdiomaService {

    List<OfertaTieneIdioma> listarIdiomasPorOferta(Integer idOferta);

    List<Idioma> listarIdiomasPorIdOferta(Integer idOferta);

}
