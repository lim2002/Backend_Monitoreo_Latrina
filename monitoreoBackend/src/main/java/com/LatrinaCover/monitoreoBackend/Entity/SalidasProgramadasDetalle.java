package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "salidas_programadas_detalle")
public class SalidasProgramadasDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_salidas_programadas_detalle", nullable = false)
    private Integer idSalidaProgramadaDetalle;

    @ManyToOne
    @JoinColumn(name = "id_salida_programada", nullable = false)
    private SalidasProgramadas salidaProgramada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nota_salida", nullable = false)
    private NotasSalidas notaSalida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nota_salida_detalle", nullable = false)
    private NotasSalidaDetalle notaSalidaDetalle;

    @Column(name = "producto_nombre", nullable = false)
    private String productoNombre;

    @Column(name = "producto_codigo", nullable = false)
    private String productoCodigo;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;

    @Column(name = "estado_observacion")
    private Integer estadoObservacion;

    @Column(name = "estado_entrega", nullable = false)
    private Integer estadoEntrega;

    @Column(name = "status", nullable = false)
    private Integer status;

    public SalidasProgramadasDetalle() {
    }

    public SalidasProgramadasDetalle(Integer idSalidaProgramadaDetalle, SalidasProgramadas salidaProgramada, NotasSalidas notaSalida, NotasSalidaDetalle notaSalidaDetalle, String productoNombre, String productoCodigo, Integer cantidad, String descripcion, BigDecimal precioUnitario, Integer estadoObservacion, Integer estadoEntrega, Integer status) {
        this.idSalidaProgramadaDetalle = idSalidaProgramadaDetalle;
        this.salidaProgramada = salidaProgramada;
        this.notaSalida = notaSalida;
        this.notaSalidaDetalle = notaSalidaDetalle;
        this.productoNombre = productoNombre;
        this.productoCodigo = productoCodigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.estadoObservacion = estadoObservacion;
        this.estadoEntrega = estadoEntrega;
        this.status = status;
    }

    public NotasSalidas getNotaSalida() {
        return notaSalida;
    }

    public void setNotaSalida(NotasSalidas notaSalida) {
        this.notaSalida = notaSalida;
    }

    public Integer getIdSalidaProgramadaDetalle() {
        return idSalidaProgramadaDetalle;
    }

    public void setIdSalidaProgramadaDetalle(Integer idSalidaProgramadaDetalle) {
        this.idSalidaProgramadaDetalle = idSalidaProgramadaDetalle;
    }

    public SalidasProgramadas getSalidaProgramada() {
        return salidaProgramada;
    }

    public void setSalidaProgramada(SalidasProgramadas salidaProgramada) {
        this.salidaProgramada = salidaProgramada;
    }

    public NotasSalidaDetalle getNotaSalidaDetalle() {
        return notaSalidaDetalle;
    }

    public void setNotaSalidaDetalle(NotasSalidaDetalle notaSalidaDetalle) {
        this.notaSalidaDetalle = notaSalidaDetalle;
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
        return "SalidasProgramadasDetalle{" +
                "idSalidaProgramadaDetalle=" + idSalidaProgramadaDetalle +
                ", salidaProgramada=" + salidaProgramada +
                ", notaSalida=" + notaSalida +
                ", notaSalidaDetalle=" + notaSalidaDetalle +
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
