package com.escalab.service.impl;

import com.escalab.dto.FiltroDTO;
import com.escalab.model.Guia;
import com.escalab.repo.IGuiaRepo;
import com.escalab.service.IGuiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuiaServiceImpl implements IGuiaService {

    @Autowired
    private IGuiaRepo repo;

    @Override
    public Guia registrar(Guia obj) {
        return repo.save(obj);
    }

    @Override
    public Guia modificar(Guia obj) {
        return repo.save(obj);
    }

    @Override
    public List<Guia> listar() {
        return repo.findAll();
    }

    @Override
    public Guia leerPorId(Integer id) {
        Optional<Guia> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Guia();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public List<Guia> buscarGuiaPorNombre(FiltroDTO filtro) {
        return repo.buscarPorNombreGuia(filtro.getNombreCompleto());
    }
}
