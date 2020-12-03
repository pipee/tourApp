package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Rol;
import com.escalab.service.IRolService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService service;

    @ApiOperation(value = "Listar Roles")
    @GetMapping
    public ResponseEntity<List<Rol>> listar() {
        List<Rol> lista = service.listar();
        return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Listar Rol por id")
    @GetMapping("/{id}")
    public ResponseEntity<Rol> listarPorId(@PathVariable("id") Integer id) {
        Rol obj = service.leerPorId(id);
        if (obj.getIdRol() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        return new ResponseEntity<Rol>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Registrar Rol")
    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Rol rol) {
        Rol obj = service.registrar(rol);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRol()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Modificar Rol")
    @PutMapping
    public ResponseEntity<Rol> modificar(@Valid @RequestBody Rol rol) {
        Rol obj = service.modificar(rol);
        return new ResponseEntity<Rol>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar Rol")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        Rol obj = service.leerPorId(id);
        if (obj.getIdRol() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
