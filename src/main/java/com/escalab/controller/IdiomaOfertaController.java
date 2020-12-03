package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Idioma;
import com.escalab.model.OfertaTieneIdioma;
import com.escalab.service.IOfertaTieneIdiomaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/idiomaoferta")
public class IdiomaOfertaController {

    @Autowired
    private IOfertaTieneIdiomaService service;

    @ApiOperation(value = "Listar oferta con idiomas")
    @GetMapping(value = "/{idOferta}")
    public ResponseEntity<List<OfertaTieneIdioma>> listar(@PathVariable("idOferta") Integer idOferta) {
        List<OfertaTieneIdioma> ofertaTieneIdiomas = new ArrayList<>();
        ofertaTieneIdiomas = service.listarIdiomasPorOferta(idOferta);
        return new ResponseEntity<List<OfertaTieneIdioma>>(ofertaTieneIdiomas, HttpStatus.OK);
    }

    @ApiOperation(value = "Listar idiomas por id oferta")
    @GetMapping(value = "idiomasporoferta/{idOferta}")
    public ResponseEntity<List<Idioma>> listarIdiomas(@PathVariable("idOferta") Integer idOferta) {
        List<Idioma> idiomas = new ArrayList<>();
        idiomas = service.listarIdiomasPorIdOferta(idOferta);
        if (idiomas.isEmpty()){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + idOferta);
        }
        return new ResponseEntity<List<Idioma>>(idiomas, HttpStatus.OK);
    }
}
