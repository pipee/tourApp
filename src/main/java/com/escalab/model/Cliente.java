package com.escalab.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @ApiModelProperty(notes = "Nombres debe tener minimo 2 caracteres")
    @Size(min = 2, message = "Nombres debe tener minimo 2 caracteres")
    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @ApiModelProperty(notes = "Apellidos debe tener minimo 2 caracteres")
    @Size(min = 2, message = "Apellidos debe tener minimo 2 caracteres")
    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

    @ApiModelProperty(notes = "Nacionalidad debe tener minimo 3 caracteres")
    @Size(min = 3, message = "Nacionalidad debe tener minimo 3 caracteres")
    @Column(name = "nacionalidad", nullable = false, length = 30)
    private String nacionalidad;

    @Email
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @ApiModelProperty(notes = "Telefono debe tener 9 caracteres")
    @Size(min = 9, max = 9, message = "DNI debe tener 9 caracteres")
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @Column(name = "foto_url_cliente")
    private String fotoUrlCliente;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFotoUrlCliente() {
        return fotoUrlCliente;
    }

    public void setFotoUrlCliente(String fotoUrlCliente) {
        this.fotoUrlCliente = fotoUrlCliente;
    }
}
