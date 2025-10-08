package com.LatrinaCover.monitoreoBackend.Dto;

import java.math.BigDecimal;

public class SalidasProgramadasDetalleDto {

    private Integer idSalidaProgramadaDetalle;
    private Integer idSalidaProgramada;
    private Integer idNotaSalida;
    private Short idNotaSalidaDetalle;
    private String productoNombre;
    private String productoCodigo;
    private Integer cantidad;
    private String descripcion;
    private BigDecimal precioUnitario;
    private Integer estadoObservacion;
    private Integer estadoEntrega;
    private Integer status;

    public SalidasProgramadasDetalleDto() {
    }

    public SalidasProgramadasDetalleDto(Integer idSalidaProgramadaDetalle, Integer idSalidaProgramada, Integer idNotaSalida, Short idNotaSalidaDetalle, String productoNombre, String productoCodigo, Integer cantidad, String descripcion, BigDecimal precioUnitario, Integer estadoObservacion, Integer estadoEntrega, Integer status) {
        this.idSalidaProgramadaDetalle = idSalidaProgramadaDetalle;
        this.idSalidaProgramada = idSalidaProgramada;
        this.idNotaSalida = idNotaSalida;
        this.idNotaSalidaDetalle = idNotaSalidaDetalle;
        this.productoNombre = productoNombre;
        this.productoCodigo = productoCodigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.estadoObservacion = estadoObservacion;
        this.estadoEntrega = estadoEntrega;
        this.status = status;
    }

    // Getters and Setters


    public Integer getIdSalidaProgramadaDetalle() {
        return idSalidaProgramadaDetalle;
    }

    public void setIdSalidaProgramadaDetalle(Integer idSalidaProgramadaDetalle) {
        this.idSalidaProgramadaDetalle = idSalidaProgramadaDetalle;
    }

    public Integer getIdSalidaProgramada() {
        return idSalidaProgramada;
    }

    public void setIdSalidaProgramada(Integer idSalidaProgramada) {
        this.idSalidaProgramada = idSalidaProgramada;
    }

    public Integer getIdNotaSalida() {
        return idNotaSalida;
    }

    public void setIdNotaSalida(Integer idNotaSalida) {
        this.idNotaSalida = idNotaSalida;
    }

    public Short getIdNotaSalidaDetalle() {
        return idNotaSalidaDetalle;
    }

    public void setIdNotaSalidaDetalle(Short idNotaSalidaDetalle) {
        this.idNotaSalidaDetalle = idNotaSalidaDetalle;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public String getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(String productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getEstadoObservacion() {
        return estadoObservacion;
    }

    public void setEstadoObservacion(Integer estadoObservacion) {
        this.estadoObservacion = estadoObservacion;
    }

    public Integer getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(Integer estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SalidasProgramadasDetalleDto{" +
                "idSalidaProgramadaDetalle=" + idSalidaProgramadaDetalle +
                ", idSalidaProgramada=" + idSalidaProgramada +
                ", idNotaSalida=" + idNotaSalida +
                ", idNotaSalidaDetalle=" + idNotaSalidaDetalle +
                ", productoNombre='" + productoNombre + '\'' +
                ", productoCodigo='" + productoCodigo + '\'' +
                ", cantidad=" + cantidad +
                ", descripcion='" + descripcion + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", estadoObservacion=" + estadoObservacion +
                ", estadoEntrega=" + estadoEntrega +
                ", status=" + status +
                '}';
    }
}
