package com.escalab.service.impl;

import com.escalab.model.Idioma;
import com.escalab.model.OfertaTieneIdioma;
import com.escalab.repo.IOfertaTieneIdiomaRepo;
import com.escalab.service.IOfertaTieneIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfertaTieneIdiomaServiceImpl implements IOfertaTieneIdiomaService {

    @Autowired
    private IOfertaTieneIdiomaRepo repo;

    @Override
    public List<OfertaTieneIdioma> listarIdiomasPorOferta(Integer idOferta) {
        return repo.listarIdiomasPorOferta(idOferta);
    }

    @Override
    public List<Idioma> listarIdiomasPorIdOferta(Integer idOferta) {
        List<Idioma> idiomas = new ArrayList<>();

        repo.listarIdiomasPorIdOferta(idOferta).forEach(x -> {
            Idioma id = new Idioma();
            id.setIdIdioma(Integer.parseInt(String.valueOf(x[0])));
            id.setNombreIdioma(String.valueOf(x[1]));
            idiomas.add(id);
        });
        return idiomas;
    }
}
