package com.LatrinaCover.monitoreoBackend.Dto;

public class UbicacionClientesDto {

    private Integer idUbicacionCliente;
    private Integer idCliente;
    private String ubicacion;
    private String nombreDireccion;
    private String status;

    public UbicacionClientesDto() {
    }

    public UbicacionClientesDto(Integer idUbicacionCliente, Integer idCliente, String ubicacion, String nombreDireccion, String status) {
        this.idUbicacionCliente = idUbicacionCliente;
        this.idCliente = idCliente;
        this.ubicacion = ubicacion;
        this.nombreDireccion = nombreDireccion;
        this.status = status;
    }

    public Integer getIdUbicacionCliente() {
        return idUbicacionCliente;
    }

    public void setIdUbicacionCliente(Integer idUbicacionCliente) {
        this.idUbicacionCliente = idUbicacionCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreDireccion() {
        return nombreDireccion;
    }

    public void setNombreDireccion(String nombreDireccion) {
        this.nombreDireccion = nombreDireccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "UbicacionClientesDto{" +
                "idUbicacionCliente=" + idUbicacionCliente +
                ", idCliente=" + idCliente +
                ", ubicacion='" + ubicacion + '\'' +
                ", nombreDireccion='" + nombreDireccion + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
