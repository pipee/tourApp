package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Menu;
import com.escalab.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private IMenuService service;

    @GetMapping
    public ResponseEntity<List<Menu>> listar() {
        List<Menu> lista = service.listar();
        return new ResponseEntity<List<Menu>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> listarPorId(@PathVariable("id") Integer id) {
        Menu obj = service.leerPorId(id);
        if (obj.getIdMenu() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        return new ResponseEntity<Menu>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Menu menu) {
        Menu obj = service.registrar(menu);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMenu()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Menu> modificar(@Valid @RequestBody Menu menu) {
        Menu obj = service.modificar(menu);
        return new ResponseEntity<Menu>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        Menu obj = service.leerPorId(id);
        if (obj.getIdMenu() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
