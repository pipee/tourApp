package com.escalab.model;

import javax.persistence.*;

@Entity
@Table(name = "idioma")
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIdioma;

    @Column(name = "nombre_idioma")
    private String nombreIdioma;

    public Integer getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNombreIdioma() {
        return nombreIdioma;
    }

    public void setNombreIdioma(String nombreIdioma) {
        this.nombreIdioma = nombreIdioma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Idioma idioma = (Idioma) o;

        return getIdIdioma() != null ? getIdIdioma().equals(idioma.getIdIdioma()) : idioma.getIdIdioma() == null;
    }

    @Override
    public int hashCode() {
        return getIdIdioma() != null ? getIdIdioma().hashCode() : 0;
    }
}
