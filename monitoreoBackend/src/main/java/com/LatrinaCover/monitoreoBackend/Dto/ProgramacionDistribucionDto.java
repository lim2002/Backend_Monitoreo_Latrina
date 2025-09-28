package com.LatrinaCover.monitoreoBackend.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProgramacionDistribucionDto {

    private Integer idProgramacion;
    private Integer idVehiculo;
    private Short idConductor;
    private Short idAdministrador;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaCreacion;   // si en DB es DATETIME/DATETIME2
    private Integer estadoEntrega;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaEntrega;        // si en DB es DATE
    private Integer status;

    public ProgramacionDistribucionDto() {
    }

    public ProgramacionDistribucionDto(Integer idProgramacion, Integer idVehiculo, Short idConductor, Short idAdministrador, LocalDateTime fechaCreacion, Integer estadoEntrega, LocalDate fechaEntrega, Integer status) {
        this.idProgramacion = idProgramacion;
        this.idVehiculo = idVehiculo;
        this.idConductor = idConductor;
        this.idAdministrador = idAdministrador;
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

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Short getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Short idConductor) {
        this.idConductor = idConductor;
    }

    public Short getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Short idAdministrador) {
        this.idAdministrador = idAdministrador;
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
        return "ProgramacionDistribucionDto{" +
                "idProgramacion=" + idProgramacion +
                ", idVehiculo=" + idVehiculo +
                ", idConductor=" + idConductor +
                ", idAdministrador=" + idAdministrador +
                ", fechaCreacion=" + fechaCreacion +
                ", estadoEntrega=" + estadoEntrega +
                ", fechaEntrega=" + fechaEntrega +
                ", status=" + status +
                '}';
    }
}
