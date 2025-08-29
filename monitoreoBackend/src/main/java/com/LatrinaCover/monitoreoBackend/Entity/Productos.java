package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "productos")
public class Productos implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;

    @Column(name = "producto_nombre", nullable = false)
    private String productoNombre;

    @Column(name = "producto_stock", nullable = false)
    private String productoCodigo;

    @Column(name = "producto_descripcion", nullable = false)
    private String productoDescripcion;

    public Productos() {
    }

    public Productos(Integer idProducto, String productoNombre, String productoCodigo, String productoDescripcion) {
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
        return "Productos{" +
                "idProducto=" + idProducto +
                ", productoNombre='" + productoNombre + '\'' +
                ", productoCodigo='" + productoCodigo + '\'' +
                ", productoDescripcion='" + productoDescripcion + '\'' +
                '}';
    }
}
