package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "notas_salidas")
public class NotasSalidas implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_nota_salida", nullable = false)
    private Integer idNotaSalida;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion_cliente", nullable = false)
    private UbicacionClientes ubicacionCliente;

    @Column(name = "nro_salida", nullable = false)
    private String nroSalida;

    @Column(name = "codigo_pedido", nullable = false)
    private String codigoPedido;

    @Column(name = "fecha_entrega", nullable = false)
    private Date fechaEntrega;

    @Column(name = "fecha_programada_entrega", nullable = false)
    private Date fechaProgramadaEntrega;

    public NotasSalidas() {
    }

    public NotasSalidas(Integer idNotaSalida, Clientes cliente, UbicacionClientes ubicacionCliente, String nroSalida, String codigoPedido, Date fechaEntrega, Date fechaProgramadaEntrega) {
        this.idNotaSalida = idNotaSalida;
        this.cliente = cliente;
        this.ubicacionCliente = ubicacionCliente;
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

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public UbicacionClientes getUbicacionCliente() {
        return ubicacionCliente;
    }

    public void setUbicacionCliente(UbicacionClientes ubicacionCliente) {
        this.ubicacionCliente = ubicacionCliente;
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

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaProgramadaEntrega() {
        return fechaProgramadaEntrega;
    }

    public void setFechaProgramadaEntrega(Date fechaProgramadaEntrega) {
        this.fechaProgramadaEntrega = fechaProgramadaEntrega;
    }

    @Override
    public String toString() {
        return "NotasSalidas{" +
                "idNotaSalida=" + idNotaSalida +
                ", cliente=" + cliente +
                ", ubicacionCliente=" + ubicacionCliente +
                ", nroSalida='" + nroSalida + '\'' +
                ", codigoPedido='" + codigoPedido + '\'' +
                ", fechaEntrega=" + fechaEntrega +
                ", fechaProgramadaEntrega=" + fechaProgramadaEntrega +
                '}';
    }
}
