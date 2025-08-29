package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "idUsuario=" + idUsuario +
                '}';
    }
}
