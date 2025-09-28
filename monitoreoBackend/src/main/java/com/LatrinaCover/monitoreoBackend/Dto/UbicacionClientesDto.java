package com.LatrinaCover.monitoreoBackend.Dto;

public class UbicacionClientesDto {

    private Short idUbicacionCliente;
    private ClientesDto cliente;
    private String ubicacion;
    private String nombreDireccion;
    private String status;

    public UbicacionClientesDto() {
    }

    public UbicacionClientesDto(Short idUbicacionCliente, ClientesDto idCliente, String ubicacion, String nombreDireccion, String status) {
        this.idUbicacionCliente = idUbicacionCliente;
        this.cliente = idCliente;
        this.ubicacion = ubicacion;
        this.nombreDireccion = nombreDireccion;
        this.status = status;
    }

    public Short getIdUbicacionCliente() {
        return idUbicacionCliente;
    }

    public void setIdUbicacionCliente(Short idUbicacionCliente) {
        this.idUbicacionCliente = idUbicacionCliente;
    }

    public ClientesDto getIdCliente() {
        return cliente;
    }

    public void setIdCliente(ClientesDto idCliente) {
        this.cliente = idCliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                ", cliente=" + cliente +
                ", ubicacion='" + ubicacion + '\'' +
                ", nombreDireccion='" + nombreDireccion + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
