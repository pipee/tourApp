package com.escalab.dto;

import com.escalab.model.Idioma;
import com.escalab.model.OfertaTour;

import java.util.List;

public class OfertaIdiomaDTO {

    private OfertaTour ofertaTour;
    private List<Idioma> idIdiomaList;

    public OfertaTour getOfertaTour() {
        return ofertaTour;
    }

    public void setOfertaTour(OfertaTour ofertaTour) {
        this.ofertaTour = ofertaTour;
    }

    public List<Idioma> getIdIdiomaList() {
        return idIdiomaList;
    }

    public void setIdIdiomaList(List<Idioma> idIdiomaList) {
        this.idIdiomaList = idIdiomaList;
    }
}
