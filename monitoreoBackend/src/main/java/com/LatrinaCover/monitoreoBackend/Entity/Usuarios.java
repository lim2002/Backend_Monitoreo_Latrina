package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "SecUser")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SecUserId", nullable = false)
    private Short idUsuario;

    @Column(name = "SecUserName", nullable = false)
    private String username;

    @Column(name = "SecUserNameFill", nullable = false)
    private String nombreCompleto;

    @Column(name = "SecUserEmail", nullable = false)
    private String correo;

    @Column(name = "SecUserCelular", nullable = false)
    private String celular;

    @Column(name = "SecUserDireccion", nullable = false)
    private String direccion;

    @Column(name = "SecUserfechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "SecUserNroLicencia", nullable = false)
    private String nroLicencia;

    @Column(name = "SecUserCategoria", nullable = false)
    private String categoria;

    @Column(name = "SecUserFechaExpiracionLicencia", nullable = false)
    private LocalDateTime fechaExpiracionLicencia;


    public Usuarios() {
    }

    public Usuarios(Short idUsuario, String username, String nombreCompleto, String correo, String celular, String direccion, LocalDate fechaNacimiento, String nroLicencia, String categoria, LocalDateTime fechaExpiracionLicencia) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.nroLicencia = nroLicencia;
        this.categoria = categoria;
        this.fechaExpiracionLicencia = fechaExpiracionLicencia;
    }

    public Short getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Short idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNroLicencia() {
        return nroLicencia;
    }

    public void setNroLicencia(String nroLicencia) {
        this.nroLicencia = nroLicencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getFechaExpiracionLicencia() {
        return fechaExpiracionLicencia;
    }

    public void setFechaExpiracionLicencia(LocalDateTime fechaExpiracionLicencia) {
        this.fechaExpiracionLicencia = fechaExpiracionLicencia;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "idUsuario=" + idUsuario +
                ", username='" + username + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correo='" + correo + '\'' +
                ", celular='" + celular + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", nroLicencia='" + nroLicencia + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fechaExpiracionLicencia=" + fechaExpiracionLicencia +
                '}';
    }
}
