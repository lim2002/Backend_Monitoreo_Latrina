package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Cliente")
public class Clientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CliCod", nullable = false)
    private Short idCliente;

    @Column(name = "CliNom", nullable = false)
    private String nombre;

    @Column(name = "CliRep", nullable = false)
    private String representante;

    @Column(name = "CliTel", nullable = false)
    private String telefono;

    @Column(name = "CliCel", nullable = false)
    private String celular;

    @Column(name = "CliFax", nullable = false)
    private String fax;

    @Column(name = "CliMail", nullable = false)
    private String email;

    public Clientes() {
    }

    public Clientes(Short idCliente, String nombre, String representante, String telefono, String celular, String fax, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.representante = representante;
        this.telefono = telefono;
        this.celular = celular;
        this.fax = fax;
        this.email = email;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
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

    @Override
    public String toString() {
        return "Clientes{" +
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
