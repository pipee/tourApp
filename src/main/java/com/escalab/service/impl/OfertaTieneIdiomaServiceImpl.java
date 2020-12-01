package com.escalab.service.impl;

import com.escalab.model.OfertaTieneIdioma;
import com.escalab.repo.IOfertaTieneIdiomaRepo;
import com.escalab.service.IOfertaTieneIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OfertaTieneIdiomaServiceImpl implements IOfertaTieneIdiomaService {

    @Autowired
    private IOfertaTieneIdiomaRepo repo;

    @Override
    public List<OfertaTieneIdioma> listarIdiomasPorOferta(Integer idOferta) {
        return repo.listarIdiomasPorOferta(idOferta);
    }
}
