package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "programacion_distribucion")
public class ProgramacionDistribucion implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_programacion", nullable = false)
    private Integer idProgramacion;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculos vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_conductor", nullable = false)
    private Usuarios conductor;

    @ManyToOne
    @JoinColumn(name = "id_administrador", nullable = false)
    private Usuarios administrador;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "estado_entrega", nullable = false)
    private Integer estadoEntrega;

    @Column(name = "fecha_entrega", nullable = true)
    private LocalDate fechaEntrega;

    @Column(name = "status", nullable = false)
    private Integer status;

    public ProgramacionDistribucion() {
    }

    public ProgramacionDistribucion(Integer idProgramacion, Vehiculos vehiculo, Usuarios conductor, Usuarios administrador, LocalDateTime fechaCreacion, Integer estadoEntrega, LocalDate fechaEntrega, Integer status) {
        this.idProgramacion = idProgramacion;
        this.vehiculo = vehiculo;
        this.conductor = conductor;
        this.administrador = administrador;
        this.fechaCreacion = fechaCreacion;
        this.estadoEntrega = estadoEntrega;
        this.fechaEntrega = fechaEntrega;
        this.status = status;
    }

    public Integer getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Integer idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public Vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Usuarios getConductor() {
        return conductor;
    }

    public void setConductor(Usuarios conductor) {
        this.conductor = conductor;
    }

    public Usuarios getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuarios administrador) {
        this.administrador = administrador;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(Integer estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProgramacionDistribucion{" +
                "idProgramacion=" + idProgramacion +
                ", vehiculo=" + vehiculo +
                ", conductor=" + conductor +
                ", administrador=" + administrador +
                ", fechaCreacion=" + fechaCreacion +
                ", estadoEntrega=" + estadoEntrega +
                ", fechaEntrega=" + fechaEntrega +
                ", status=" + status +
                '}';
    }
}
