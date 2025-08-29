package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculosRepository extends JpaRepository<Vehiculos, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    //Obtener todos los vehiculos status = 1
    @Query("SELECT v FROM Vehiculos v WHERE v.status = 1")
    public List<Vehiculos> findAllVehiculos();


}
