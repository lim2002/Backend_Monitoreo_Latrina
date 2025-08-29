package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.Administradores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradoresRepository extends JpaRepository<Administradores, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
