package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.ProgramacionDistribucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProgramacionDistribucionRepository extends JpaRepository<ProgramacionDistribucion, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario

    //MOstrar todas las programaciones de distribucion desde 10/08/2025
    @Query("SELECT p FROM ProgramacionDistribucion p WHERE p.status = 1" )
    List<ProgramacionDistribucion> findAll();

    //filtrar programacion de distribucion por idProgramacion y rango de fecha
    @Query("""
        SELECT p
        FROM ProgramacionDistribucion p
        WHERE p.status = 1
          AND (:idProg IS NULL OR p.idProgramacion = :idProg)
          AND (:desde  IS NULL OR p.fechaEntrega >= :desde)
          AND (:hasta  IS NULL OR p.fechaEntrega <= :hasta)
        ORDER BY p.fechaEntrega DESC, p.idProgramacion DESC
    """)
    List<ProgramacionDistribucion> findAllByIdAndFecha(
            @Param("idProg") Integer idProg,
            @Param("desde")  LocalDate desde,
            @Param("hasta")  LocalDate hasta
    );


    //Filtar programaciones de distribucion por conductor
    @Query("""
    SELECT p
    FROM ProgramacionDistribucion p
    WHERE p.status = 1
      AND p.conductor.idUsuario = :idConductor
      AND (:idProg IS NULL OR p.idProgramacion = :idProg)
      AND (:desde  IS NULL OR p.fechaEntrega >= :desde)
      AND (:hasta  IS NULL OR p.fechaEntrega <= :hasta)
    ORDER BY p.fechaEntrega DESC, p.idProgramacion DESC
    """)
    List<ProgramacionDistribucion> findAllByConductorRequiredAndFecha(
            @Param("idConductor") Integer idConductor,
            @Param("idProg")      Integer idProg,
            @Param("desde")       LocalDate desde,
            @Param("hasta")       LocalDate hasta
    );

    //Obtener programacion de distribucion por idProgramacion
    @Query("SELECT p FROM ProgramacionDistribucion p WHERE p.idProgramacion = ?1" )
    ProgramacionDistribucion findByIdProgramacion(Integer idProgramacion);


}
