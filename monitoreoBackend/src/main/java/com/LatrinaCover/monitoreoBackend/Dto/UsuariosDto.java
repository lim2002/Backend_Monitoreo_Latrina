package com.LatrinaCover.monitoreoBackend.Dto;

import com.LatrinaCover.monitoreoBackend.Entity.Usuarios;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuariosDto {

    private Integer idUsuario;
    private String username;
    private String nombreCompleto;
    private String correo;
    private String celular;
    private String direccion;

    // SQL Server DATE -> LocalDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    private String nroLicencia;
    private String categoria;

    // DATETIME/DATETIME2 -> LocalDateTime
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaExpiracionLicencia;

    public UsuariosDto() {}

    public UsuariosDto(Integer idUsuario, String username, String nombreCompleto, String correo, String celular, String direccion, LocalDate fechaNacimiento, String nroLicencia, String categoria, LocalDateTime fechaExpiracionLicencia) {
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

    public static UsuariosDto of(Usuarios u) {
        if (u == null) return null;
        UsuariosDto dto = new UsuariosDto();
        dto.idUsuario = u.getIdUsuario();
        dto.username = u.getUsername();
        dto.nombreCompleto = u.getNombreCompleto();
        dto.correo = u.getCorreo();
        dto.celular = u.getCelular();
        dto.direccion = u.getDireccion();
        dto.fechaNacimiento = u.getFechaNacimiento();
        dto.nroLicencia = u.getNroLicencia();
        dto.categoria = u.getCategoria();
        dto.fechaExpiracionLicencia = u.getFechaExpiracionLicencia();
        return dto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
        return "UsuariosDto{" +
                "idUsuario=" + idUsuario +
                ", username='" + username + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correo='" + correo + '\'' +
                ", celular='" + celular + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nroLicencia='" + nroLicencia + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fechaExpiracionLicencia=" + fechaExpiracionLicencia +
                '}';
    }
}
