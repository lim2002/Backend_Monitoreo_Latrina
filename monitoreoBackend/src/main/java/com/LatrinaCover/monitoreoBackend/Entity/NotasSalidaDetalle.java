package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

 @Entity
 @Table(name = "notas_salida_detalle")
public class NotasSalidaDetalle implements Serializable {

     @Id
     @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
     @Column(name = "id_nota_salida_detalle", nullable = false)
     private Short idNotaSalidaDetalle;

     @ManyToOne
     @JoinColumn(name = "id_salida", nullable = false)
     private NotasSalidas notasSalida;

     @ManyToOne
     @JoinColumn(name = "id_producto", nullable = false)
     private Productos producto;

     @Column(name = "producto_nombre", nullable = false)
     private String productoNombre;

     @Column(name = "producto_codigo", nullable = false)
     private String productoCodigo;

     @Column(name = "cantidad", nullable = false)
     private Integer cantidad;

     @Column(name = "descripcion", nullable = false)
     private String descripcion;

     @Column(name = "precio_unitario", nullable = false)
     private Double precioUnitario;

     @Column(name = "status", nullable = false)
     private Integer status;

     public NotasSalidaDetalle() {
     }

     public NotasSalidaDetalle(Short idNotaSalidaDetalle, NotasSalidas notasSalida, String productoNombre, Productos producto, String productoCodigo, Integer cantidad, String descripcion, Double precioUnitario, Integer status) {
         this.idNotaSalidaDetalle = idNotaSalidaDetalle;
         this.notasSalida = notasSalida;
         this.productoNombre = productoNombre;
         this.producto = producto;
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

     public NotasSalidas getNotasSalida() {
         return notasSalida;
     }

     public void setNotasSalida(NotasSalidas notasSalida) {
         this.notasSalida = notasSalida;
     }

     public Productos getProducto() {
         return producto;
     }

     public void setProducto(Productos producto) {
         this.producto = producto;
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

     @Override
     public String toString() {
         return "NotasSalidaDetalle{" +
                 "idNotaSalidaDetalle=" + idNotaSalidaDetalle +
                 ", notasSalida=" + notasSalida +
                 ", producto=" + producto +
                 ", productoNombre='" + productoNombre + '\'' +
                 ", productoCodigo='" + productoCodigo + '\'' +
                 ", cantidad=" + cantidad +
                 ", descripcion='" + descripcion + '\'' +
                 ", precioUnitario=" + precioUnitario +
                 ", status=" + status +
                 '}';
     }
 }
