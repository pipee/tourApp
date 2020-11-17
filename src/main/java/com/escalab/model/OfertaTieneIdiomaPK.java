package com.escalab.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class OfertaTieneIdiomaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_idioma", nullable = false)
    private Idioma idioma;

    @ManyToOne
    @JoinColumn(name = "id_oferta", nullable = false)
    private OfertaTour ofertaTour;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfertaTieneIdiomaPK that = (OfertaTieneIdiomaPK) o;

        if (idioma != null ? !idioma.equals(that.idioma) : that.idioma != null) return false;
        return ofertaTour != null ? ofertaTour.equals(that.ofertaTour) : that.ofertaTour == null;
    }

    @Override
    public int hashCode() {
        int result = idioma != null ? idioma.hashCode() : 0;
        result = 31 * result + (ofertaTour != null ? ofertaTour.hashCode() : 0);
        return result;
    }
}
