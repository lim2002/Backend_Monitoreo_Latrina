package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VehiculosRepository extends JpaRepository<Vehiculos, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    //Obtener todos los vehiculos status = 1
    @Query("SELECT v FROM Vehiculos v WHERE v.status = 1")
    public List<Vehiculos> findAllVehiculos();

    //obtener todos los vehiculos con status 1 y que en la tabla de programacion de distribucion el estado de la entrega este en 3
    @Query("""
       SELECT DISTINCT v
       FROM Vehiculos v
       WHERE v.status = 1
         AND NOT EXISTS (
             SELECT 1
             FROM ProgramacionDistribucion p
             WHERE p.vehiculo = v
               AND p.fechaEntrega = :fecha
               AND p.estadoEntrega IN (0,1)
               AND p.status = 1
         )
       """)
    public List<Vehiculos> findDisponiblesParaProgramar(@Param("fecha") LocalDate fecha);



}
