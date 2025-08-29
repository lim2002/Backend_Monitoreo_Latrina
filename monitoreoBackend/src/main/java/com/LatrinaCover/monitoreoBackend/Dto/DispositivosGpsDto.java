package com.LatrinaCover.monitoreoBackend.Dto;

public class DispositivosGpsDto {

    private Integer idDispositivo;
    private String codigo;
    private String modelo;
    private Integer activo;
    private Integer status;

    public DispositivosGpsDto() {
    }

    public DispositivosGpsDto(Integer idDispositivo, String codigo, String modelo, Integer activo, Integer status) {
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
        return "DispositivosGpsDto{" +
                "idDispositivo=" + idDispositivo +
                ", codigo='" + codigo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", activo=" + activo +
                ", status=" + status +
                '}';
    }
}
