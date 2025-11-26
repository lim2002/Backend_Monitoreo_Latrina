package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.Vehiculos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VehiculosRepository extends JpaRepository<Vehiculos, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    //Obtener todos los vehiculos status = 1
    @Query("SELECT v FROM Vehiculos v WHERE v.status = 1")
    public Page<Vehiculos> findAllVehiculos(Pageable pageable);

    //obtener todos los vehiculos con status 1 y que en la tabla de programacion de distribucion el estado de la entrega este en 3
    @Query("""
       SELECT DISTINCT v
       FROM Vehiculos v
       WHERE v.status = 1
         AND NOT EXISTS (
             SELECT 1
             FROM ProgramacionDistribucion p
             WHERE p.vehiculo = v
               AND p.fechaEntrega = :fecha
               AND p.estadoEntrega IN (0,1)
               AND p.status = 1
         )
       """)
    public List<Vehiculos> findDisponiblesParaProgramar(@Param("fecha") LocalDate fecha);

    //mostrar todos los vehiculos
    @Query("""
        SELECT v
        FROM Vehiculos v
        WHERE v.status = 1
          AND (
                :q IS NULL OR TRIM(:q) = ''
                OR UPPER(v.placa)  LIKE UPPER(CONCAT('%', :q, '%'))
                OR UPPER(v.modelo) LIKE UPPER(CONCAT('%', :q, '%'))
          )
        ORDER BY v.placa ASC
        """)
    Page<Vehiculos> findAllOrFilterByPlacaOrModelo(@Param("q") String q, Pageable pageable);



    Vehiculos findByIdVehiculo(Integer idVehiculo);

    //obtener el id del dispositivo por id vehiculo
    @Query("SELECT v.dispositivo.idDispositivo FROM Vehiculos v WHERE v.idVehiculo = ?1")
    public Integer findIdDispositivoByIdVehiculo(Integer idVehiculo);

    //verificar si el vehiculo no tiene programacion de distribucion activa para una fecha dada
    @Query("""
        SELECT CASE 
                 WHEN COUNT(p) > 0 THEN true
                 ELSE false
               END
        FROM ProgramacionDistribucion p
        WHERE p.vehiculo.idVehiculo = :idVehiculo
          AND p.fechaEntrega = :fecha
          AND p.estadoEntrega IN (0, 1)
          AND p.status = 1
        """)
    public Boolean existsActiveProgramacionForVehiculoOnDate(@Param("idVehiculo") Integer idVehiculo,
                                                             @Param("fecha") LocalDate fecha);
}
