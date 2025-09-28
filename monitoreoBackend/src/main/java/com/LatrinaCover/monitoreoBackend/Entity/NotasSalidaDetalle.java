package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
 @Table(name = "RecProdLevel1")
public class NotasSalidaDetalle implements Serializable {

     @Id
     @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
     @Column(name = "RecLin", nullable = false)
     private Short idNotaSalidaDetalle;

     @ManyToOne
     @JoinColumn(name = "RecNum", nullable = false)
     private NotasSalidas notasSalida;

     @Column(name = "RecProdNom", nullable = false)
     private String productoNombre;

     @Column(name = "RecProdCod", nullable = false)
     private String productoCodigo;

     @Column(name = "RecCan", nullable = false)
     private BigDecimal cantidad;

     @Column(name = "RecProdUni", nullable = false)
     private String descripcion;

     @Column(name = "SalUnit", nullable = false)
     private BigDecimal precioUnitario;


     public NotasSalidaDetalle() {
     }

    public NotasSalidaDetalle(Short idNotaSalidaDetalle, NotasSalidas notasSalida, String productoNombre, String productoCodigo, BigDecimal cantidad, String descripcion, BigDecimal precioUnitario) {
        this.idNotaSalidaDetalle = idNotaSalidaDetalle;
        this.notasSalida = notasSalida;
        this.productoNombre = productoNombre;
        this.productoCodigo = productoCodigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
    }

    public Short getIdNotaSalidaDetalle() {
        return idNotaSalidaDetalle;
    }

    public void setIdNotaSalidaDetalle(Short idNotaSalidaDetalle) {
        this.idNotaSalidaDetalle = idNotaSalidaDetalle;
    }

    public NotasSalidas getNotasSalida() {
        return notasSalida;
    }

    public void setNotasSalida(NotasSalidas notasSalida) {
        this.notasSalida = notasSalida;
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

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
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

    @Override
    public String toString() {
        return "NotasSalidaDetalle{" +
                "idNotaSalidaDetalle=" + idNotaSalidaDetalle +
                ", notasSalida=" + notasSalida +
                ", productoNombre='" + productoNombre + '\'' +
                ", productoCodigo='" + productoCodigo + '\'' +
                ", cantidad=" + cantidad +
                ", descripcion='" + descripcion + '\'' +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
