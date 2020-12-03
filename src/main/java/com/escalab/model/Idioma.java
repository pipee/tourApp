package com.escalab.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "idioma")
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIdioma;

    @ApiModelProperty(notes = "Nombre Idioma debe tener minimo 3 caracteres")
    @Size(min = 3, message = "Nombre Idioma debe tener minimo 3 caracteres")
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
