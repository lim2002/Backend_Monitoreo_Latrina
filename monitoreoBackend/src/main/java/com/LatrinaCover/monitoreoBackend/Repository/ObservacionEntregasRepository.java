package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.ObservacionEntregas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObservacionEntregasRepository extends JpaRepository<ObservacionEntregas, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario

    //mostrar todas las observaciones por id programacion salida
    @Query("SELECT o FROM ObservacionEntregas o WHERE o.salidasProgramadasDetalle.salidaProgramada.idSalidaProgramada = ?1" )
    public List<ObservacionEntregas> findByProgramacionSalidaId(Integer id);

    //obtener observacion por id
    @Query("SELECT o FROM ObservacionEntregas o WHERE o.salidasProgramadasDetalle.idSalidaProgramadaDetalle = ?1" )
    public ObservacionEntregas findObservacionBySalidasProgramadaDetalle(Integer id);
}
