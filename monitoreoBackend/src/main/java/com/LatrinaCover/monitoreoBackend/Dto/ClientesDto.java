package com.LatrinaCover.monitoreoBackend.Dto;

public class ClientesDto {

    private Short idCliente;
    private String nombre;
    private String representante;
    private String telefono;
    private String celular;
    private String fax;
    private String email;

    public ClientesDto() {
    }

    public ClientesDto(Short idCliente, String nombre, String representante, String telefono, String celular, String fax, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.representante = representante;
        this.telefono = telefono;
        this.celular = celular;
        this.fax = fax;
        this.email = email;
    }

    public Short getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Short idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    @Override
    public String toString() {
        return "ClientesDto{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", representante='" + representante + '\'' +
                ", telefono='" + telefono + '\'' +
                ", celular='" + celular + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
