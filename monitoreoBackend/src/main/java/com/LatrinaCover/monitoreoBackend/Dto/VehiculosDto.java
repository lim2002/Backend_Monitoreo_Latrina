package com.LatrinaCover.monitoreoBackend.Dto;

import com.LatrinaCover.monitoreoBackend.Entity.Vehiculos;

import java.time.LocalDate;

public class VehiculosDto {

    private Integer idVehiculo;
    private Integer idDispositivoGps;
    private String placa;
    private String marca;
    private String modelo;
    private Integer anio;
    private Integer capacidadKg;
    private String estadoVehiculo;
    private LocalDate fechaUltimoMantenimiento;
    private Integer status;

    public VehiculosDto() {
    }

    public VehiculosDto(Integer idVehiculo, Integer idDispositivoGps, String marca, String placa, String modelo, Integer anio, Integer capacidadKg, String estadoVehiculo, LocalDate fechaUltimoMantenimiento, Integer status) {
        this.idVehiculo = idVehiculo;
        this.idDispositivoGps = idDispositivoGps;
        this.marca = marca;
        this.placa = placa;
        this.modelo = modelo;
        this.anio = anio;
        this.capacidadKg = capacidadKg;
        this.estadoVehiculo = estadoVehiculo;
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
        this.status = status;
    }

    public static VehiculosDto of(Vehiculos v) {
        if (v == null) return null;
        VehiculosDto dto = new VehiculosDto();
        dto.idVehiculo = v.getIdVehiculo();
        dto.idDispositivoGps = v.getDispositivo().getIdDispositivo();
        dto.marca = v.getMarca();
        dto.placa = v.getPlaca();
        dto.modelo = v.getModelo();
        dto.anio = v.getAnio();
        dto.capacidadKg = v.getCapacidadKg();
        dto.estadoVehiculo = v.getEstadoVehiculo();
        dto.fechaUltimoMantenimiento = v.getFechaUltimoMantenimiento();
        dto.status = v.getStatus();
        return dto;
    }

    public Integer getIdDispositivoGps() {
        return idDispositivoGps;
    }

    public void setIdDispositivoGps(Integer idDispositivoGps) {
        this.idDispositivoGps = idDispositivoGps;
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

    public Integer getCapacidadKg() {
        return capacidadKg;
    }

    public void setCapacidadKg(Integer capacidadKg) {
        this.capacidadKg = capacidadKg;
    }

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
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
        return "VehiculosDto{" +
                "idVehiculo=" + idVehiculo +
                ", idDispositivoGps=" + idDispositivoGps +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", capacidadKg=" + capacidadKg +
                ", estadoVehiculo='" + estadoVehiculo + '\'' +
                ", fechaUltimoMantenimiento='" + fechaUltimoMantenimiento + '\'' +
                ", status=" + status +
                '}';
    }
}
