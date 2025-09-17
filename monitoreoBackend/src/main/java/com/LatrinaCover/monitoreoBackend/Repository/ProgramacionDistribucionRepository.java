package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.ProgramacionDistribucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProgramacionDistribucionRepository extends JpaRepository<ProgramacionDistribucion, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario

    //MOstrar todas las programaciones de distribucion desde 10/08/2025
    @Query("SELECT p FROM ProgramacionDistribucion p WHERE p.status = 1" )
    List<ProgramacionDistribucion> findAll();
}
