package com.LatrinaCover.monitoreoBackend.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class SalidasProgramadasDto {

    private Integer idSalidaProgramada;
    private Integer idProgramacion;
    private Integer idNotaSalida;
    private ClientesDto cliente;
    private UbicacionClientesDto ubicacion;
    private String nroSalida;
    private Integer estadoEntrega;
    private Integer ordenPrioridadRuta;
    private String ubicacionEntrega;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fechaEntregaConfirmada;
    private Integer status;

    public SalidasProgramadasDto() {
    }

    public SalidasProgramadasDto(Integer idSalidaProgramada, Integer idProgramacion, Integer idNotaSalida, ClientesDto cliente, UbicacionClientesDto ubicacion, String nroSalida, Integer estadoEntrega, Integer ordenPrioridadRuta, String ubicacionEntrega, LocalDateTime fechaEntregaConfirmada, Integer status) {
        this.idSalidaProgramada = idSalidaProgramada;
        this.idProgramacion = idProgramacion;
        this.idNotaSalida = idNotaSalida;
        this.cliente = cliente;
        this.ubicacion = ubicacion;
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

    public Integer getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Integer idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public Integer getIdNotaSalida() {
        return idNotaSalida;
    }

    public void setIdNotaSalida(Integer idNotaSalida) {
        this.idNotaSalida = idNotaSalida;
    }

    public ClientesDto getCliente() {
        return cliente;
    }

    public void setCliente(ClientesDto cliente) {
        this.cliente = cliente;
    }

    public UbicacionClientesDto getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionClientesDto ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNroSalida() {
        return nroSalida;
    }

    public void setNroSalida(String nroSalida) {
        this.nroSalida = nroSalida;
    }

    public Integer getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(Integer estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public Integer getOrdenPrioridadRuta() {
        return ordenPrioridadRuta;
    }

    public void setOrdenPrioridadRuta(Integer ordenPrioridadRuta) {
        this.ordenPrioridadRuta = ordenPrioridadRuta;
    }

    public String getUbicacionEntrega() {
        return ubicacionEntrega;
    }

    public void setUbicacionEntrega(String ubicacionEntrega) {
        this.ubicacionEntrega = ubicacionEntrega;
    }

    public LocalDateTime getFechaEntregaConfirmada() {
        return fechaEntregaConfirmada;
    }

    public void setFechaEntregaConfirmada(LocalDateTime fechaEntregaConfirmada) {
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
        return "SalidasProgramadasDto{" +
                "idSalidaProgramada=" + idSalidaProgramada +
                ", idProgramacion=" + idProgramacion +
                ", idNotaSalida=" + idNotaSalida +
                ", cliente=" + cliente +
                ", ubicacion=" + ubicacion +
                ", nroSalida='" + nroSalida + '\'' +
                ", estadoEntrega=" + estadoEntrega +
                ", ordenPrioridadRuta=" + ordenPrioridadRuta +
                ", ubicacionEntrega='" + ubicacionEntrega + '\'' +
                ", fechaEntregaConfirmada=" + fechaEntregaConfirmada +
                ", status=" + status +
                '}';
    }
}
