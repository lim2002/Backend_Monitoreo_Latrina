package com.LatrinaCover.monitoreoBackend.Dto;

public class ConductoresDto {

    private Integer idConductor;
    private Integer idUsuario;
    private String fechaNacimiento;
    private String licencia;
    private String tipoLicencia;
    private String fechaExpiracionLicencia;
    private Integer estado;

    public ConductoresDto() {
    }

    public ConductoresDto(Integer idConductor, Integer idUsuario, String fechaNacimiento, String licencia, String tipoLicencia, String fechaExpiracionLicencia, Integer estado) {
        this.idConductor = idConductor;
        this.idUsuario = idUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.licencia = licencia;
        this.tipoLicencia = tipoLicencia;
        this.fechaExpiracionLicencia = fechaExpiracionLicencia;
        this.estado = estado;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getFechaExpiracionLicencia() {
        return fechaExpiracionLicencia;
    }

    public void setFechaExpiracionLicencia(String fechaExpiracionLicencia) {
        this.fechaExpiracionLicencia = fechaExpiracionLicencia;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ConductoresDto{" +
                "idConductor=" + idConductor +
                ", idUsuario=" + idUsuario +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", licencia='" + licencia + '\'' +
                ", tipoLicencia='" + tipoLicencia + '\'' +
                ", fechaExpiracionLicencia='" + fechaExpiracionLicencia + '\'' +
                ", estado=" + estado +
                '}';
    }
}
