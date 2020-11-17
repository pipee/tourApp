package com.escalab.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "oferta_tiene_idioma")
@IdClass(OfertaTieneIdiomaPK.class)
public class OfertaTieneIdioma {

    @Id
    private Idioma idioma;

    @Id
    private OfertaTour ofertaTour;

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public OfertaTour getOfertaTour() {
        return ofertaTour;
    }

    public void setOfertaTour(OfertaTour ofertaTour) {
        this.ofertaTour = ofertaTour;
    }
}
