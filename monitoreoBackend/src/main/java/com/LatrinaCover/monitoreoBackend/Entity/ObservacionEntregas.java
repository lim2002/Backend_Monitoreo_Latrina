package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "observacion_entregas")
public class ObservacionEntregas implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_observacion_entrega", nullable = false)
    private Integer idObservacionEntrega;

    @ManyToOne
    @JoinColumn(name = "id_conductor", nullable = false)
    private Usuarios conductor;

    @ManyToOne
    @JoinColumn(name = "id_salidas_programadas_detalle", nullable = false)
    private SalidasProgramadasDetalle salidasProgramadasDetalle;

    @Column(name = "observacion", nullable = false)
    private String observacion;

    @Column(name = "estado_entrega", nullable = false)
    private String estadoEntrega;

    @Column(name = "status", nullable = false)
    private Integer status;

    public ObservacionEntregas() {
    }

    public ObservacionEntregas(Integer idObservacionEntrega, Usuarios conductor, SalidasProgramadasDetalle salidasProgramadasDetalle, String observacion, String estadoEntrega, Integer status) {
        this.idObservacionEntrega = idObservacionEntrega;
        this.conductor = conductor;
        this.salidasProgramadasDetalle = salidasProgramadasDetalle;
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

    public Usuarios getConductor() {
        return conductor;
    }

    public void setConductor(Usuarios conductor) {
        this.conductor = conductor;
    }

    public SalidasProgramadasDetalle getSalidasProgramadasDetalle() {
        return salidasProgramadasDetalle;
    }

    public void setSalidasProgramadasDetalle(SalidasProgramadasDetalle salidasProgramadasDetalle) {
        this.salidasProgramadasDetalle = salidasProgramadasDetalle;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ObservacionEntregas{" +
                "idObservacionEntrega=" + idObservacionEntrega +
                ", conductor=" + conductor +
                ", salidasProgramadasDetalle=" + salidasProgramadasDetalle +
                ", observacion='" + observacion + '\'' +
                ", estadoEntrega='" + estadoEntrega + '\'' +
                ", status=" + status +
                '}';
    }
}
