package com.LatrinaCover.monitoreoBackend.Dto;

public class ZonasDto {

    private Integer idZona;
    private String zonaCodigo;
    private String zonaNombre;
    private Integer status;

    public ZonasDto() {
    }

    public ZonasDto(Integer idZona, String zonaCodigo, String zonaNombre, Integer status) {
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
        return "ZonasDto{" +
                "idZona=" + idZona +
                ", zonaCodigo='" + zonaCodigo + '\'' +
                ", zonaNombre='" + zonaNombre + '\'' +
                ", status=" + status +
                '}';
    }
}
