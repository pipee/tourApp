package com.escalab.controller;

import com.escalab.dto.FiltroDTO;
import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Cliente;
import com.escalab.service.IClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> lista = service.listar();
        return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id) {
        Cliente obj = service.leerPorId(id);
        if (obj.getIdCliente() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Cliente cliente) {
        Cliente obj = service.registrar(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/buscarpornombre")
    public ResponseEntity<List<Cliente>> buscarPorNombre(@RequestBody FiltroDTO filtro) {
        List<Cliente> clientes = new ArrayList<>();
        clientes = service.buscarPorNombreCliente(filtro);
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente cliente) {
        Cliente obj = service.modificar(cliente);
        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        Cliente obj = service.leerPorId(id);
        if (obj.getIdCliente() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
