package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesarioq
}
