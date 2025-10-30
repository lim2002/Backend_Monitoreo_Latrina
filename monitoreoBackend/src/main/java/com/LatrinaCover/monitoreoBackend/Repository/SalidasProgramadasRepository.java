package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.SalidasProgramadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalidasProgramadasRepository extends JpaRepository<SalidasProgramadas, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario

    //obtener las salida programadas por id programacion
    @Query("SELECT s FROM SalidasProgramadas s WHERE s.programacion.idProgramacion = ?1" )
    public List<SalidasProgramadas> findByIdProgramacion(Integer idProgramacion);

    //obtener las salida programadas por id salida programada
    @Query("SELECT s FROM SalidasProgramadas s WHERE s.idSalidaProgramada = ?1" )
    public SalidasProgramadas findByIdSalidaProgramada(Integer idSalidaProgramada);
}
