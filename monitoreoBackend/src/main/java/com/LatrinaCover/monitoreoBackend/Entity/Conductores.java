package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "conductores")
public class Conductores implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_conductor", nullable = false)
    private Integer idConductor;


    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuario;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "licencia", nullable = false)
    private String licencia;

    @Column(name = "tipo_licencia", nullable = false)
    private String tipoLicencia;

    @Column(name = "fecha_expiracion_licencia", nullable = false)
    private Date fechaExpiracionLicencia;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    public Conductores() {
    }

    public Conductores(Integer idConductor, Usuarios usuario, Date fechaNacimiento, String licencia, String tipoLicencia, Date fechaExpiracionLicencia, Integer estado) {
        this.idConductor = idConductor;
        this.usuario = usuario;
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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

    public Date getFechaExpiracionLicencia() {
        return fechaExpiracionLicencia;
    }

    public void setFechaExpiracionLicencia(Date fechaExpiracionLicencia) {
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
        return "Conductores{" +
                "idConductor=" + idConductor +
                ", usuario=" + usuario +
                ", fechaNacimiento=" + fechaNacimiento +
                ", licencia='" + licencia + '\'' +
                ", tipoLicencia='" + tipoLicencia + '\'' +
                ", fechaExpiracionLicencia=" + fechaExpiracionLicencia +
                ", estado=" + estado +
                '}';
    }
}
