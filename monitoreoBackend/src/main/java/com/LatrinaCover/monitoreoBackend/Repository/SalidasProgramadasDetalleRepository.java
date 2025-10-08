package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.SalidasProgramadasDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalidasProgramadasDetalleRepository extends JpaRepository<SalidasProgramadasDetalle, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario

    //Obtener las salidas programadas detalle por idSalidaProgramada
    @Query("SELECT spd FROM SalidasProgramadasDetalle spd WHERE spd.salidaProgramada.idSalidaProgramada = ?1" )
    public List<SalidasProgramadasDetalle> findByIdSalidaProgramada(Integer idSalidaProgramada);

    //Obtener salida programada Detalle por id
    @Query("SELECT spd FROM SalidasProgramadasDetalle spd WHERE spd.idSalidaProgramadaDetalle = ?1" )
    public SalidasProgramadasDetalle findByIdSalidaProgramadaDetalle(Integer idSalidaProgramadaDetalle);

}
