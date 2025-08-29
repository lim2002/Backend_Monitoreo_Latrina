package com.LatrinaCover.monitoreoBackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "vehiculos")
public class Vehiculos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo", nullable = false)
    private Integer idVehiculo;

    @ManyToOne
    @JoinColumn(name = "id_dispositivo", nullable = false)
    private DispositivosGps dispositivo;

    @Column(name = "placa", nullable = false)
    private String placa;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "capacidad_kg", nullable = false)
    private Integer capacidadKg;

    @Column(name = "estado_vehiculo", nullable = false)
    private String estadoVehiculo;

    @Column(name = "fecha_ultimo_mantenimiento", nullable = false)
    private LocalDate fechaUltimoMantenimiento;

    @Column(name = "status", nullable = false)
    private Integer status;

    public Vehiculos() {
    }

    public Vehiculos(Integer idVehiculo, DispositivosGps dispositivo, String placa, String marca, String modelo, Integer anio, Integer capacidadKg, String estadoVehiculo, LocalDate fechaUltimoMantenimiento, Integer status) {
        this.idVehiculo = idVehiculo;
        this.dispositivo = dispositivo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.capacidadKg = capacidadKg;
        this.estadoVehiculo = estadoVehiculo;
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
        this.status = status;
    }

    public DispositivosGps getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivosGps dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public Integer getCapacidadKg() {
        return capacidadKg;
    }

    public void setCapacidadKg(Integer capacidadKg) {
        this.capacidadKg = capacidadKg;
    }

    public LocalDate getFechaUltimoMantenimiento() {
        return fechaUltimoMantenimiento;
    }

    public void setFechaUltimoMantenimiento(LocalDate fechaUltimoMantenimiento) {
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehiculos{" +
                "idVehiculo=" + idVehiculo +
                ", dispositivo=" + dispositivo +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", capacidadKg=" + capacidadKg +
                ", estadoVehiculo='" + estadoVehiculo + '\'' +
                ", fechaUltimoMantenimiento=" + fechaUltimoMantenimiento +
                ", status=" + status +
                '}';
    }
}
