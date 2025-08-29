package com.LatrinaCover.monitoreoBackend.Dto;

public class NotasSalidasDto {

    private Integer idNotaSalida;
    private Integer idCliente;
    private Integer idUbicacionCliente;
    private String nroSalida;
    private String codigoPedido;
    private String fechaEntrega;
    private String fechaProgramadaEntrega;

    public NotasSalidasDto() {
    }

    public NotasSalidasDto(Integer idNotaSalida, Integer idCliente, Integer idUbicacionCliente, String nroSalida, String codigoPedido, String fechaEntrega, String fechaProgramadaEntrega) {
        this.idNotaSalida = idNotaSalida;
        this.idCliente = idCliente;
        this.idUbicacionCliente = idUbicacionCliente;
        this.nroSalida = nroSalida;
        this.codigoPedido = codigoPedido;
        this.fechaEntrega = fechaEntrega;
        this.fechaProgramadaEntrega = fechaProgramadaEntrega;
    }

    public Integer getIdNotaSalida() {
        return idNotaSalida;
    }

    public void setIdNotaSalida(Integer idNotaSalida) {
        this.idNotaSalida = idNotaSalida;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdUbicacionCliente() {
        return idUbicacionCliente;
    }

    public void setIdUbicacionCliente(Integer idUbicacionCliente) {
        this.idUbicacionCliente = idUbicacionCliente;
    }

    public String getNroSalida() {
        return nroSalida;
    }

    public void setNroSalida(String nroSalida) {
        this.nroSalida = nroSalida;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaProgramadaEntrega() {
        return fechaProgramadaEntrega;
    }

    public void setFechaProgramadaEntrega(String fechaProgramadaEntrega) {
        this.fechaProgramadaEntrega = fechaProgramadaEntrega;
    }

    @Override
    public String toString() {
        return "NotasSalidasDto{" +
                "idNotaSalida=" + idNotaSalida +
                ", idCliente=" + idCliente +
                ", idUbicacionCliente=" + idUbicacionCliente +
                ", nroSalida='" + nroSalida + '\'' +
                ", codigoPedido='" + codigoPedido + '\'' +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                ", fechaProgramadaEntrega='" + fechaProgramadaEntrega + '\'' +
                '}';
    }
}
