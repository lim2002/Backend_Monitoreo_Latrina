package com.LatrinaCover.monitoreoBackend.Dto;

public class ProductosDto {

    private Integer idProducto;
    private String productoNombre;
    private String productoCodigo;
    private String productoDescripcion;

    public ProductosDto() {
    }

    public ProductosDto(Integer idProducto, String productoNombre, String productoCodigo, String productoDescripcion) {
        this.idProducto = idProducto;
        this.productoNombre = productoNombre;
        this.productoCodigo = productoCodigo;
        this.productoDescripcion = productoDescripcion;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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

    public String getProductoDescripcion() {
        return productoDescripcion;
    }

    public void setProductoDescripcion(String productoDescripcion) {
        this.productoDescripcion = productoDescripcion;
    }

    @Override
    public String toString() {
        return "ProductosDto{" +
                "idProducto=" + idProducto +
                ", productoNombre='" + productoNombre + '\'' +
                ", productoCodigo='" + productoCodigo + '\'' +
                ", productoDescripcion='" + productoDescripcion + '\'' +
                '}';
    }
}
