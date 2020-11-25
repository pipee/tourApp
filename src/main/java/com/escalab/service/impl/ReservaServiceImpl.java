package com.escalab.service.impl;

import com.escalab.model.Reserva;
import com.escalab.repo.IReservaRepo;
import com.escalab.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReservaServiceImpl implements IReservaService {

    @Autowired
    private IReservaRepo repo;

    @Override
    public Reserva registrar(Reserva obj) {
        return repo.save(obj);
    }

    @Override
    public Reserva modificar(Reserva obj) {
        return repo.save(obj);
    }

    @Override
    public List<Reserva> listar() {
        return repo.findAll();
    }

    @Override
    public Reserva leerPorId(Integer id) {
        Optional<Reserva> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Reserva();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
