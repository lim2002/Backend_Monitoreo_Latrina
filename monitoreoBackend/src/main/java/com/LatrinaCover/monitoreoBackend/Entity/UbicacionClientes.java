package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ClientesNewDireccion")
public class UbicacionClientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDDireccionCliente", nullable = false)
    private Short idUbicacionCliente;

    @ManyToOne
    @JoinColumn(name = "CliCod", nullable = false)
    private Clientes cliente;

    @Column(name = "DirCliGeoreferencia", nullable = false)
    private String ubicacion;

    @Column(name = "DirCliDireccion", nullable = false)
    private String nombreDireccion;

    @Column(name = "DirCliActivo", nullable = false)
    private String status;

    public UbicacionClientes() {
    }

    public UbicacionClientes(Short idUbicacionCliente, Clientes cliente, String ubicacion, String nombreDireccion, String status) {
        this.idUbicacionCliente = idUbicacionCliente;
        this.cliente = cliente;
        this.ubicacion = ubicacion;
        this.nombreDireccion = nombreDireccion;
        this.status = status;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Short getIdUbicacionCliente() {
        return idUbicacionCliente;
    }

    public void setIdUbicacionCliente(Short idUbicacionCliente) {
        this.idUbicacionCliente = idUbicacionCliente;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombreDireccion() {
        return nombreDireccion;
    }

    public void setNombreDireccion(String nombreDireccion) {
        this.nombreDireccion = nombreDireccion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UbicacionClientes{" +
                "cliente=" + cliente +
                ", idUbicacionCliente=" + idUbicacionCliente +
                ", ubicacion='" + ubicacion + '\'' +
                ", nombreDireccion='" + nombreDireccion + '\'' +
                ", status=" + status +
                '}';
    }
}
