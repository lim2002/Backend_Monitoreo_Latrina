package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "salidas_programadas")
public class SalidasProgramadas implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_salida_programada", nullable = false)
    private Integer idSalidaProgramada;

    @ManyToOne
    @JoinColumn(name = "id_programacion", nullable = false)
    private ProgramacionDistribucion programacion;

    @ManyToOne
    @JoinColumn(name = "id_nota_salida", nullable = false)
    private NotasSalidas notaSalida;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion_cliente", nullable = false)
    private UbicacionClientes ubicacionCliente;

    @Column(name = "nro_salida", nullable = false)
    private String nroSalida;

    @Column(name = "estado_entrega", nullable = false)
    private Integer estadoEntrega;

    @Column(name = "orden_prioridad_ruta", nullable = false)
    private Integer ordenPrioridadRuta;

    @Column(name = "ubicacion_entrega", nullable = true)
    private LocalDateTime ubicacionEntrega;

    @Column(name = "fecha_entrega_confirmada", nullable = false)
    private String fechaEntregaConfirmada;

    @Column(name = "status", nullable = false)
    private Integer status;

    public SalidasProgramadas() {
    }

    public SalidasProgramadas(Integer idSalidaProgramada, ProgramacionDistribucion programacion, NotasSalidas notaSalida, Clientes cliente, UbicacionClientes ubicacionCliente, String nroSalida, Integer estadoEntrega, Integer ordenPrioridadRuta, LocalDateTime ubicacionEntrega, String fechaEntregaConfirmada, Integer status) {
        this.idSalidaProgramada = idSalidaProgramada;
        this.programacion = programacion;
        this.notaSalida = notaSalida;
        this.cliente = cliente;
        this.ubicacionCliente = ubicacionCliente;
        this.nroSalida = nroSalida;
        this.estadoEntrega = estadoEntrega;
        this.ordenPrioridadRuta = ordenPrioridadRuta;
        this.ubicacionEntrega = ubicacionEntrega;
        this.fechaEntregaConfirmada = fechaEntregaConfirmada;
        this.status = status;
    }

    public Integer getIdSalidaProgramada() {
        return idSalidaProgramada;
    }

    public void setIdSalidaProgramada(Integer idSalidaProgramada) {
        this.idSalidaProgramada = idSalidaProgramada;
    }

    public ProgramacionDistribucion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(ProgramacionDistribucion programacion) {
        this.programacion = programacion;
    }

    public NotasSalidas getNotaSalida() {
        return notaSalida;
    }

    public void setNotaSalida(NotasSalidas notaSalida) {
        this.notaSalida = notaSalida;
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

    public Integer getOrdenPrioridadRuta() {
        return ordenPrioridadRuta;
    }

    public void setOrdenPrioridadRuta(Integer ordenPrioridadRuta) {
        this.ordenPrioridadRuta = ordenPrioridadRuta;
    }

    public Integer getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(Integer estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public LocalDateTime getUbicacionEntrega() {
        return ubicacionEntrega;
    }

    public void setUbicacionEntrega(LocalDateTime ubicacionEntrega) {
        this.ubicacionEntrega = ubicacionEntrega;
    }

    public String getFechaEntregaConfirmada() {
        return fechaEntregaConfirmada;
    }

    public void setFechaEntregaConfirmada(String fechaEntregaConfirmada) {
        this.fechaEntregaConfirmada = fechaEntregaConfirmada;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SalidasProgramadas{" +
                "idSalidaProgramada=" + idSalidaProgramada +
                ", programacion=" + programacion +
                ", notaSalida=" + notaSalida +
                ", cliente=" + cliente +
                ", ubicacionCliente=" + ubicacionCliente +
                ", nroSalida='" + nroSalida + '\'' +
                ", estadoEntrega=" + estadoEntrega +
                ", ordenPrioridadRuta=" + ordenPrioridadRuta +
                ", ubicacionEntrega='" + ubicacionEntrega + '\'' +
                ", fechaEntregaConfirmada='" + fechaEntregaConfirmada + '\'' +
                ", status=" + status +
                '}';
    }
}
