package com.LatrinaCover.monitoreoBackend.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProgramacionDistribucionLecturaDto {
    private Integer idProgramacion;

    private VehiculosDto vehiculo;
    private UsuariosDto conductor;
    private UsuariosDto administrador;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaCreacion;   // si en DB es DATETIME/DATETIME2

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaEntrega;        // si en DB es DATE

    private Integer estadoEntrega;   // o String si prefieres
    private Integer status;                // o Boolean/enum

    public ProgramacionDistribucionLecturaDto() {
    }

    public ProgramacionDistribucionLecturaDto(Integer idProgramacion, VehiculosDto vehiculo, UsuariosDto conductor, UsuariosDto administrador, LocalDateTime fechaCreacion, LocalDate fechaEntrega, Integer estadoEntrega, Integer status) {
        this.idProgramacion = idProgramacion;
        this.vehiculo = vehiculo;
        this.conductor = conductor;
        this.administrador = administrador;
        this.fechaCreacion = fechaCreacion;
        this.fechaEntrega = fechaEntrega;
        this.estadoEntrega = estadoEntrega;
        this.status = status;
    }

    public Integer getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Integer idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public VehiculosDto getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculosDto vehiculo) {
        this.vehiculo = vehiculo;
    }

    public UsuariosDto getConductor() {
        return conductor;
    }

    public void setConductor(UsuariosDto conductor) {
        this.conductor = conductor;
    }

    public UsuariosDto getAdministrador() {
        return administrador;
    }

    public void setAdministrador(UsuariosDto administrador) {
        this.administrador = administrador;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProgramacionDistribucionLecturaDto{" +
                "idProgramacion=" + idProgramacion +
                ", vehiculo=" + vehiculo +
                ", conductor=" + conductor +
                ", administrador=" + administrador +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaEntrega=" + fechaEntrega +
                ", estadoEntrega=" + estadoEntrega +
                ", status=" + status +
                '}';
    }
}
