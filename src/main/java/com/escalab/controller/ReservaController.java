package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Reserva;
import com.escalab.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private IReservaService service;

    @GetMapping
    public ResponseEntity<List<Reserva>> listar() {
        List<Reserva> lista = service.listar();
        return new ResponseEntity<List<Reserva>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> listarPorId(@PathVariable("id") Integer id) {
        Reserva obj = service.leerPorId(id);
        if (obj.getIdReserva() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        return new ResponseEntity<Reserva>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Reserva reserva) {
        Reserva obj = service.registrar(reserva);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdReserva()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Reserva> modificar(@Valid @RequestBody Reserva reserva) {
        Reserva obj = service.modificar(reserva);
        return new ResponseEntity<Reserva>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        Reserva obj = service.leerPorId(id);
        if (obj.getIdReserva() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
