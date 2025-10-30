package com.LatrinaCover.monitoreoBackend.Dto;

public class ConfirmarEntregasDto {
    private Integer idSalidaProgramadaDetalle;

    public ConfirmarEntregasDto() {
    }

    public ConfirmarEntregasDto(Integer idSalidaProgramadaDetalle) {
        this.idSalidaProgramadaDetalle = idSalidaProgramadaDetalle;
    }

    public Integer getIdSalidaProgramadaDetalle() {
        return idSalidaProgramadaDetalle;
    }

    public void setIdSalidaProgramadaDetalle(Integer idSalidaProgramadaDetalle) {
        this.idSalidaProgramadaDetalle = idSalidaProgramadaDetalle;
    }

    @Override
    public String toString() {
        return "ConfirmarEntregasDto{" +
                "idSalidaProgramadaDetalle=" + idSalidaProgramadaDetalle +
                '}';
    }
}
