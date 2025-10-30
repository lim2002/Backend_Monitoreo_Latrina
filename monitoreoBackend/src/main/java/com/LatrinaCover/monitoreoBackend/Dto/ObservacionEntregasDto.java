package com.LatrinaCover.monitoreoBackend.Dto;

public class ObservacionEntregasDto {

    private Integer idObservacionEntrega;
    private Short idConductor;
    private Integer idSalidasProgramadasDetalle;
    private String observacion;
    private Integer estadoEntrega;
    private Integer status;

    public ObservacionEntregasDto() {
    }

    public ObservacionEntregasDto(Integer idObservacionEntrega, Short idConductor, Integer idSalidasProgramadasDetalle, String observacion, Integer estadoEntrega, Integer status) {
        this.idObservacionEntrega = idObservacionEntrega;
        this.idConductor = idConductor;
        this.idSalidasProgramadasDetalle = idSalidasProgramadasDetalle;
        this.observacion = observacion;
        this.estadoEntrega = estadoEntrega;
        this.status = status;
    }

    public Integer getIdObservacionEntrega() {
        return idObservacionEntrega;
    }

    public void setIdObservacionEntrega(Integer idObservacionEntrega) {
        this.idObservacionEntrega = idObservacionEntrega;
    }

    public Short getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Short idConductor) {
        this.idConductor = idConductor;
    }

    public Integer getIdSalidasProgramadasDetalle() {
        return idSalidasProgramadasDetalle;
    }

    public void setIdSalidasProgramadasDetalle(Integer idSalidasProgramadasDetalle) {
        this.idSalidasProgramadasDetalle = idSalidasProgramadasDetalle;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        return "ObservacionEntregasDto{" +
                "idObservacionEntrega=" + idObservacionEntrega +
                ", idConductor=" + idConductor +
                ", idSalidasProgramadasDetalle=" + idSalidasProgramadasDetalle +
                ", observacion='" + observacion + '\'' +
                ", estadoEntrega='" + estadoEntrega + '\'' +
                ", status=" + status +
                '}';
    }
}
