package com.escalab.service.impl;

import com.escalab.dto.FiltroDTO;
import com.escalab.dto.OfertaIdiomaDTO;
import com.escalab.model.Idioma;
import com.escalab.model.OfertaTour;
import com.escalab.repo.IOfertaTieneIdiomaRepo;
import com.escalab.repo.IOfertaTourRepo;
import com.escalab.service.IOfertaTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfertaTourServiceImpl implements IOfertaTourService {

    @Autowired
    private IOfertaTourRepo repo;

    @Autowired
    private IOfertaTieneIdiomaRepo ofIRepo;

    @Override
    public OfertaTour registrar(OfertaTour obj) {
        return repo.save(obj);
    }

    @Override
    public OfertaTour modificar(OfertaTour obj) {
        return repo.save(obj);
    }

    @Override
    public List<OfertaTour> listar() {
        return repo.findAll();
    }

    @Override
    public OfertaTour leerPorId(Integer id) {
        Optional<OfertaTour> op = repo.findById(id);
        return op.isPresent() ? op.get() : new OfertaTour();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public List<OfertaTour> listarTourPorNombreGuia(FiltroDTO filtroDTO) {
        return repo.listarTourPorNombreGuia(filtroDTO.getNombreCompleto());
    }

    @Override
    public List<OfertaTour> listarTourPorIdGuia(Integer id) {
        return repo.listarTourPorIdGuia(id);
    }

    @Override
    public List<OfertaIdiomaDTO> listarTourDetalle() {
        List<OfertaIdiomaDTO> ofertaIdiomaDTOList = new ArrayList<>();
        listar().forEach(x -> {
            OfertaIdiomaDTO ot = new OfertaIdiomaDTO();
            List<Idioma> idiomas = new ArrayList<>();
            ofIRepo.listarIdiomasPorIdOferta(x.getIdOferta()).forEach(y -> {
                Idioma id = new Idioma();
                id.setIdIdioma(Integer.parseInt(String.valueOf(y[0])));
                id.setNombreIdioma(String.valueOf(y[1]));
                idiomas.add(id);
            });
            ot.setOfertaTour(x);
            ot.setIdIdiomaList(idiomas);
            ofertaIdiomaDTOList.add(ot);
        });
        return ofertaIdiomaDTOList;
    }

    @Transactional
    @Override
    public OfertaTour registrarOFerta(OfertaIdiomaDTO dto) {
        repo.save(dto.getOfertaTour());

        dto.getIdIdiomaList().forEach(idioma -> ofIRepo.registrar(idioma.getIdIdioma(),dto.getOfertaTour().getIdOferta()));

        return dto.getOfertaTour();
    }
}
