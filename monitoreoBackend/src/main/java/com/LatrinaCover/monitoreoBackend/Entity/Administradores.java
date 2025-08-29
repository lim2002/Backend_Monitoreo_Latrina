package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "administradores")
public class Administradores implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_administrador", nullable = false)
    private Integer idAdministrador;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuario;

    @Column(name = "carnet", nullable = false)
    private String carnet;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    public Administradores() {
    }

    public Administradores(Integer idAdministrador, Usuarios usuario, String carnet, Integer estado) {
        this.idAdministrador = idAdministrador;
        this.usuario = usuario;
        this.carnet = carnet;
        this.estado = estado;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Administradores{" +
                "idAdministrador=" + idAdministrador +
                ", usuario=" + usuario +
                ", carnet='" + carnet + '\'' +
                ", estado=" + estado +
                '}';
    }

}
