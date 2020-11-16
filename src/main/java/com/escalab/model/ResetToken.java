package com.escalab.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String token;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id_usuario")
    private Usuario user;

    @Column(nullable = false)
    private LocalDateTime expiracion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public LocalDateTime getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(int expiracion) {
        LocalDateTime hoy = LocalDateTime.now();
        this.expiracion = hoy.plusMinutes(expiracion);
    }
}
