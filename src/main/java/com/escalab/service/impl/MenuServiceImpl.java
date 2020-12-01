package com.escalab.service.impl;

import com.escalab.model.Menu;
import com.escalab.repo.IMenuRepo;
import com.escalab.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

    @Override
    public List<Menu> listarMenuPorUsuario(String nombre) {

        List<Menu> menuList = new ArrayList<>();
        repo.listarMenuPorUsuario(nombre).forEach(obj -> {
            Menu mn = new Menu();
            mn.setIdMenu(Integer.parseInt(String.valueOf(obj[0])));
            mn.setIcono(String.valueOf(obj[1]));
            mn.setNombre(String.valueOf(obj[2]));
            mn.setUrl(String.valueOf(obj[3]));

            menuList.add(mn);
        });
        return menuList;
    }
}
