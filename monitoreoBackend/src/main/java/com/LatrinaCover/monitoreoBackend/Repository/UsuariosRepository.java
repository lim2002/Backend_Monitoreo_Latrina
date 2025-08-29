package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
