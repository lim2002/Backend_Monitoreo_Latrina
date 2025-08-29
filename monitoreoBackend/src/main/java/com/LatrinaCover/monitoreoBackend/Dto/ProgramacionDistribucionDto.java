package com.LatrinaCover.monitoreoBackend.Dto;

public class ProgramacionDistribucionDto {

    private Integer idProgramacion;
    private Integer idVehiculo;
    private Integer idConductor;
    private Integer idAdministrador;
    private String fechaCreacion;
    private Integer estadoEntrega;
    private String fechaEntrega;
    private Integer status;

    public ProgramacionDistribucionDto() {
    }

    public ProgramacionDistribucionDto(Integer idProgramacion, Integer idVehiculo, Integer idConductor, Integer idAdministrador, String fechaCreacion, Integer estadoEntrega, String fechaEntrega, Integer status) {
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

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(Integer estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
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
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", estadoEntrega=" + estadoEntrega +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                ", status=" + status +
                '}';
    }
}
