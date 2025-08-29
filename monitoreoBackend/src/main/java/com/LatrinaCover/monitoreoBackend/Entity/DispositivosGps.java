package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "dispositivos_gps")
public class DispositivosGps implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dispositivo", nullable = false)
    private Integer idDispositivo;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "activo", nullable = false)
    private Integer activo;

    @Column(name = "status", nullable = false)
    private Integer status;

    public DispositivosGps() {
    }

    public DispositivosGps(Integer idDispositivo, String codigo, String modelo, Integer activo, Integer status) {
        this.idDispositivo = idDispositivo;
        this.codigo = codigo;
        this.modelo = modelo;
        this.activo = activo;
        this.status = status;
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DispositivosGps{" +
                "idDispositivo=" + idDispositivo +
                ", codigo='" + codigo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", activo=" + activo +
                ", status=" + status +
                '}';
    }
}
