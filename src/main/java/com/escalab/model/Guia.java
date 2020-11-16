package com.escalab.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "guia")
public class Guia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGuia;

    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @Email
    @Column(name = "email", nullable = false, length = 55)
    private String email;

    @Column(name = "foto_url_guia")
    private String fotoUrlGuia;

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFotoUrlGuia() {
        return fotoUrlGuia;
    }

    public void setFotoUrlGuia(String fotoUrlGuia) {
        this.fotoUrlGuia = fotoUrlGuia;
    }
}
