package com.escalab.model;

import javax.persistence.*;

@Entity
@Table(name = "oferta_tour")
public class OfertaTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOferta;

    @Column(name = "lugar", nullable = false, length = 80)
    private String lugar;

    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    @Column(name = "duracion", nullable = false)
    private float duracion;

    @ManyToOne
    @JoinColumn(name = "id_guia", nullable = false, foreignKey = @ForeignKey(name = "FK_oferta_guia"))
    private Guia guia;

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfertaTour that = (OfertaTour) o;

        return getIdOferta() != null ? getIdOferta().equals(that.getIdOferta()) : that.getIdOferta() == null;
    }

    @Override
    public int hashCode() {
        return getIdOferta() != null ? getIdOferta().hashCode() : 0;
    }
}
