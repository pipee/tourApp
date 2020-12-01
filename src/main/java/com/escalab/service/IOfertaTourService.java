package com.escalab.service;

import com.escalab.dto.OfertaIdiomaDTO;
import com.escalab.model.OfertaTour;

import java.util.List;

public interface IOfertaTourService extends ICRUD<OfertaTour> {

    List<OfertaTour> listarTourPorNombreGuia(String nombre);

    List<OfertaTour> listarTourPorIdGuia(Integer id);

    OfertaTour registrarOFerta(OfertaIdiomaDTO ofertaIdiomaDTO);

    List<OfertaIdiomaDTO> listarTourDetalle();

}
