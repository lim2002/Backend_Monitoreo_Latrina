package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.ProgramacionDistribucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramacionDistribucionRepository extends JpaRepository<ProgramacionDistribucion, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
