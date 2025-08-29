package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.UbicacionClientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionClientesRepository extends JpaRepository<UbicacionClientes, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
