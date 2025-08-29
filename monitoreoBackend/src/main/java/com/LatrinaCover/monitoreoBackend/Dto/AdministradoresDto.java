package com.LatrinaCover.monitoreoBackend.Dto;

public class AdministradoresDto {

    private String idAdministrador;
    private String idUsuario;
    private String carnet;
    private String estado;

    public AdministradoresDto() {
    }

    public AdministradoresDto(String idAdministrador, String idUsuario, String carnet, String estado) {
        this.idAdministrador = idAdministrador;
        this.idUsuario = idUsuario;
        this.carnet = carnet;
        this.estado = estado;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "AdministradoresDto{" +
                "idAdministrador='" + idAdministrador + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", carnet='" + carnet + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
