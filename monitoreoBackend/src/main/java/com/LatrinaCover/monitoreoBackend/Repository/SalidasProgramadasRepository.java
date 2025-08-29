package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.SalidasProgramadas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalidasProgramadasRepository extends JpaRepository<SalidasProgramadas, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
