package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "zonas")
public class Zonas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona", nullable = false)
    private Integer idZona;

    @Column(name = "zona_codigo", nullable = false)
    private String zonaCodigo;

    @Column(name = "zona_nombre", nullable = false)
    private String zonaNombre;

    @Column(name = "status", nullable = false)
    private Integer status;

    public Zonas() {
    }

    public Zonas(Integer idZona, String zonaCodigo, String zonaNombre, Integer status) {
        this.idZona = idZona;
        this.zonaCodigo = zonaCodigo;
        this.zonaNombre = zonaNombre;
        this.status = status;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public String getZonaCodigo() {
        return zonaCodigo;
    }

    public void setZonaCodigo(String zonaCodigo) {
        this.zonaCodigo = zonaCodigo;
    }

    public String getZonaNombre() {
        return zonaNombre;
    }

    public void setZonaNombre(String zonaNombre) {
        this.zonaNombre = zonaNombre;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Zonas{" +
                "idZona=" + idZona +
                ", zonaCodigo='" + zonaCodigo + '\'' +
                ", zonaNombre='" + zonaNombre + '\'' +
                ", status=" + status +
                '}';
    }
}
