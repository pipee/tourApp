package com.escalab.service.impl;

import com.escalab.model.Menu;
import com.escalab.repo.IMenuRepo;
import com.escalab.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuRepo repo;

    @Override
    public Menu registrar(Menu obj) {
        return repo.save(obj);
    }

    @Override
    public Menu modificar(Menu obj) {
        return repo.save(obj);
    }

    @Override
    public List<Menu> listar() {
        return repo.findAll();
    }

    @Override
    public Menu leerPorId(Integer id) {
        Optional<Menu> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Menu();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
