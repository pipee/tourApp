package com.escalab.controller;

import com.escalab.dto.FiltroDTO;
import com.escalab.dto.OfertaIdiomaDTO;
import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.OfertaTour;
import com.escalab.service.IOfertaTourService;
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
@RequestMapping("/ofertatour")
public class OfertaTourController {

    @Autowired
    private IOfertaTourService service;

    @ApiOperation(value = "Listar Ofertas")
    @GetMapping
    public ResponseEntity<List<OfertaIdiomaDTO>> listar() {
        List<OfertaIdiomaDTO> lista = service.listarTourDetalle();
        return new ResponseEntity<List<OfertaIdiomaDTO>>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Listar Oferta por id")
    @GetMapping("/{id}")
    public ResponseEntity<OfertaTour> listarPorId(@PathVariable("id") Integer id) {
        OfertaTour obj = service.leerPorId(id);
        if (obj.getIdOferta() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        return new ResponseEntity<OfertaTour>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Listar Oferta por id guia")
    @GetMapping("guia/{idguia}")
    public ResponseEntity<List<OfertaTour>> listarPorGuiaId(@PathVariable("idguia") Integer idguia) {
        List<OfertaTour> lista = service.listarTourPorIdGuia(idguia);
        if (lista.isEmpty()) {
            throw new ModelNotFoundException("IDGUIA NO ENCONTRADO" + idguia);
        }
        return new ResponseEntity<List<OfertaTour>>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Listar Oferta por nombre guia")
    @PostMapping("/guia")
    public ResponseEntity<List<OfertaTour>> buscarPorNombre(@RequestBody FiltroDTO filtro) {
        List<OfertaTour> lista = new ArrayList<>();
        lista = service.listarTourPorNombreGuia(filtro);
        if (lista.isEmpty()) {
            throw new ModelNotFoundException("NOMBRE NO ENCONTRADO" + filtro.getNombreCompleto());
        }
        return new ResponseEntity<List<OfertaTour>>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Registrar Oferta")
    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody OfertaIdiomaDTO ofertaIdiomaDTO) {
        OfertaTour obj = service.registrarOFerta(ofertaIdiomaDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdOferta()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Modificar Oferta")
    @PutMapping
    public ResponseEntity<OfertaTour> modificar(@Valid @RequestBody OfertaTour ofertaTour) {
        OfertaTour obj = service.modificar(ofertaTour);
        return new ResponseEntity<OfertaTour>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar Oferta")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        OfertaTour obj = service.leerPorId(id);
        if (obj.getIdOferta() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
