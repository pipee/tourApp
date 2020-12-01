package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Idioma;
import com.escalab.service.IIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/idiomas")
public class IdiomaController {

    @Autowired
    private IIdiomaService service;

    @GetMapping
    public ResponseEntity<List<Idioma>> listar() {
        List<Idioma> lista = service.listar();
        return new ResponseEntity<List<Idioma>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Idioma> listarPorId(@PathVariable("id") Integer id) {
        Idioma obj = service.leerPorId(id);
        if (obj.getIdIdioma() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        return new ResponseEntity<Idioma>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Idioma idioma) {
        Idioma obj = service.registrar(idioma);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdIdioma()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Idioma> modificar(@Valid @RequestBody Idioma idioma) {
        Idioma obj = service.modificar(idioma);
        return new ResponseEntity<Idioma>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        Idioma obj = service.leerPorId(id);
        if (obj.getIdIdioma() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
