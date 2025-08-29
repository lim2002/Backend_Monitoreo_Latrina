package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.ObservacionEntregas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservacionEntregasRepository extends JpaRepository<ObservacionEntregas, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
