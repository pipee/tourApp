package com.escalab.controller;

import com.escalab.dto.FiltroDTO;
import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Cliente;
import com.escalab.service.IClienteService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Lista de clientes")
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> lista = service.listar();
        return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista cliente por id")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id) {
        Cliente obj = service.leerPorId(id);
        if (obj.getIdCliente() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Registrar de cliente")
    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Cliente cliente) {
        Cliente obj = service.registrar(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Lista cliente por nombre")
    @PostMapping("/buscarpornombre")
    public ResponseEntity<List<Cliente>> buscarPorNombre(@RequestBody FiltroDTO filtro) {
        List<Cliente> clientes = new ArrayList<>();
        clientes = service.buscarPorNombreCliente(filtro);
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }

    @ApiOperation(value = "Modifica cliente")
    @PutMapping
    public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente cliente) {
        Cliente obj = service.modificar(cliente);
        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina cliente")
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
