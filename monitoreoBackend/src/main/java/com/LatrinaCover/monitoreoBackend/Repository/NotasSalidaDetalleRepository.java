package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.NotasSalidaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotasSalidaDetalleRepository extends JpaRepository<NotasSalidaDetalle, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario

    //obtener las notas de salida detalle de una idnotasalida
    @Query("SELECT nsd FROM NotasSalidaDetalle nsd WHERE nsd.notasSalida.idNotaSalida = ?1" )
    public List<NotasSalidaDetalle> findNotasSalidaDetalleByIdNotaSalida(Integer idNotaSalida);

}
