package com.LatrinaCover.monitoreoBackend.Dto;

public class UsuariosDto {

    private Integer idUsuario;

    public UsuariosDto() {
    }

    public UsuariosDto(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "UsuariosDto{" +
                "idUsuario=" + idUsuario +
                '}';
    }

}
