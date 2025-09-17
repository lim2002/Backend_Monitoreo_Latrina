package com.LatrinaCover.monitoreoBackend.Dto;

public class NotasSalidaDetalleDto {

    private Short idNotaSalidaDetalle;
    private Integer idSalida;
    private String productoNombre;
    private Integer idProducto;
    private String productoCodigo;
    private Integer cantidad;
    private String descripcion;
    private Double precioUnitario;
    private Integer status;

    public NotasSalidaDetalleDto() {
    }

    public NotasSalidaDetalleDto(Short idNotaSalidaDetalle, Integer idSalida, String productoNombre, Integer idProducto, String productoCodigo, Integer cantidad, String descripcion, Double precioUnitario, Integer status) {
        this.idNotaSalidaDetalle = idNotaSalidaDetalle;
        this.idSalida = idSalida;
        this.productoNombre = productoNombre;
        this.idProducto = idProducto;
        this.productoCodigo = productoCodigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.status = status;
    }

    public Short getIdNotaSalidaDetalle() {
        return idNotaSalidaDetalle;
    }

    public void setIdNotaSalidaDetalle(Short idNotaSalidaDetalle) {
        this.idNotaSalidaDetalle = idNotaSalidaDetalle;
    }

    public Integer getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
