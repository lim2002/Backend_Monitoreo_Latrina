package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.NotasSalidaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotasSalidaDetalleRepository extends JpaRepository<NotasSalidaDetalle, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
