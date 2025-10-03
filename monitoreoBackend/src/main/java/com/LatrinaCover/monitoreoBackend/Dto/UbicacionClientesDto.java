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

    public ClientesDto getCliente() { return cliente; }
    public void setCliente(ClientesDto cliente) { this.cliente = cliente; }

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

    private static Short toShort(Number n) {
        return n == null ? null : n.shortValue();
    }

    public static UbicacionClientesDto of(com.LatrinaCover.monitoreoBackend.Entity.UbicacionClientes e) {
        if (e == null) return null;

        // Funciona tanto si getIdUbicacionCliente() devuelve Short como Integer
        Short idUb = toShort((Number) e.getIdUbicacionCliente());

        return new UbicacionClientesDto(
                idUb,
                ClientesDto.of(e.getCliente()),
                e.getUbicacion(),
                e.getNombreDireccion(),
                e.getStatus()
        );
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
