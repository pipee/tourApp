package com.escalab.service.impl;

import com.escalab.model.Idioma;
import com.escalab.repo.IIdiomaRepo;
import com.escalab.service.IIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class IdiomaServiceImpl implements IIdiomaService {

    @Autowired
    private IIdiomaRepo repo;

    @Override
    public Idioma registrar(Idioma obj) {
        return repo.save(obj);
    }

    @Override
    public Idioma modificar(Idioma obj) {
        return repo.save(obj);
    }

    @Override
    public List<Idioma> listar() {
        return repo.findAll();
    }

    @Override
    public Idioma leerPorId(Integer id) {
        Optional<Idioma> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Idioma();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
