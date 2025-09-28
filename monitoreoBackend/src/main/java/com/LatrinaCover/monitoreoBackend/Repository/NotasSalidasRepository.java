package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.NotasSalidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface NotasSalidasRepository extends JpaRepository<NotasSalidas, Integer> {

    //Mostrar todos los registros de notas de salidas desde 01/08/2025 y que no tengan un registro creado en la tabla de salidas programadas relacionadas por id_nota_salida
    @Query("""
       SELECT n
       FROM NotasSalidas n
       WHERE n.fechaSalida >= :fromDate
         AND NOT EXISTS (
           SELECT 1
           FROM SalidasProgramadas s
           WHERE s.notaSalida.idNotaSalida = n.idNotaSalida
         )
    """)
    List<NotasSalidas> findAllNotasSalidasWithoutSalidasProgramadas(@Param("fromDate") LocalDateTime fromDate);

}
