package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.Conductores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductoresRepository extends JpaRepository<Conductores, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
