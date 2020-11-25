package com.escalab.service.impl;

import com.escalab.model.OfertaTour;
import com.escalab.repo.IOfertaTourRepo;
import com.escalab.service.IOfertaTourService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OfertaTourServiceImpl implements IOfertaTourService {

    @Autowired
    private IOfertaTourRepo repo;

    @Override
    public OfertaTour registrar(OfertaTour obj) {
        return repo.save(obj);
    }

    @Override
    public OfertaTour modificar(OfertaTour obj) {
        return repo.save(obj);
    }

    @Override
    public List<OfertaTour> listar() {
        return repo.findAll();
    }

    @Override
    public OfertaTour leerPorId(Integer id) {
        Optional<OfertaTour> op = repo.findById(id);
        return op.isPresent() ? op.get() : new OfertaTour();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
