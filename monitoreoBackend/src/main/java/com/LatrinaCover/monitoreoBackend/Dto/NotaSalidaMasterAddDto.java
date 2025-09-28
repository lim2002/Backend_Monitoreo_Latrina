package com.LatrinaCover.monitoreoBackend.Dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotaSalidaMasterAddDto {

    private Integer idNotaSalida;
    /** Cliente dueño de la nota de salida */
    private ClientesDto cliente;
    /** Todas las ubicaciones del cliente */
    private UbicacionClientesDto ubicaciones;

    private Integer nroSalida;
    private Integer codigoPedido;
    private LocalDateTime fechaSalidaAprobada;
    private LocalDateTime fechaSalida;

    public NotaSalidaMasterAddDto() {
    }

    public NotaSalidaMasterAddDto(Integer idNotaSalida, ClientesDto cliente, UbicacionClientesDto ubicaciones, Integer nroSalida, Integer codigoPedido, LocalDateTime fechaSalidaAprobada, LocalDateTime fechaSalida) {
        this.idNotaSalida = idNotaSalida;
        this.cliente = cliente;
        this.ubicaciones = ubicaciones;
        this.nroSalida = nroSalida;
        this.codigoPedido = codigoPedido;
        this.fechaSalidaAprobada = fechaSalidaAprobada;
        this.fechaSalida = fechaSalida;
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

    public UbicacionClientesDto getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(UbicacionClientesDto ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public Integer getNroSalida() {
        return nroSalida;
    }

    public void setNroSalida(Integer nroSalida) {
        this.nroSalida = nroSalida;
    }

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public LocalDateTime getFechaSalidaAprobada() {
        return fechaSalidaAprobada;
    }

    public void setFechaSalidaAprobada(LocalDateTime fechaSalidaAprobada) {
        this.fechaSalidaAprobada = fechaSalidaAprobada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "NotaSalidaMasterAddDto{" +
                "idNotaSalida=" + idNotaSalida +
                ", cliente=" + cliente +
                ", ubicaciones=" + ubicaciones +
                ", nroSalida=" + nroSalida +
                ", codigoPedido=" + codigoPedido +
                ", fechaSalidaAprobada=" + fechaSalidaAprobada +
                ", fechaSalida=" + fechaSalida +
                '}';
    }
}
