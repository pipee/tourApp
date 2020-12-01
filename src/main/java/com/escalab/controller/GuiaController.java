package com.escalab.controller;

import com.escalab.dto.FiltroDTO;
import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Guia;
import com.escalab.service.IGuiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/guias")
public class GuiaController {

    @Autowired
    private IGuiaService service;

    @GetMapping
    public ResponseEntity<List<Guia>> listar() {
        List<Guia> lista = service.listar();
        return new ResponseEntity<List<Guia>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guia> listarPorId(@PathVariable("id") Integer id) {
        Guia obj = service.leerPorId(id);
        if (obj.getIdGuia() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        return new ResponseEntity<Guia>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Guia guia) {
        Guia obj = service.registrar(guia);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGuia()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/buscarpornombre")
    public ResponseEntity<List<Guia>> buscarPorNombre(@RequestBody FiltroDTO filtro) {
        List<Guia> guias = new ArrayList<>();
        guias = service.buscarGuiaPorNombre(filtro);
        return new ResponseEntity<List<Guia>>(guias, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Guia> modificar(@Valid @RequestBody Guia guia) {
        Guia obj = service.modificar(guia);
        return new ResponseEntity<Guia>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        Guia obj = service.leerPorId(id);
        if (obj.getIdGuia() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
