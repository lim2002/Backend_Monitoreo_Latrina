package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UsuariosRepository extends JpaRepository<Usuarios, Short> {
    // Aquí puedes agregar métodos personalizados si es necesario

    //Obtener usuario por idUsuario
    @Query("SELECT u FROM Usuarios u WHERE u.idUsuario = ?1")
    public Usuarios findByIdUsuario(Integer idUsuario);

    //obtener los usuarios que son coductores
    @Query(value = """
        SELECT DISTINCT u.*
        FROM SecUser u
        JOIN SecUserRole ur ON ur.SecUserId = u.SecUserId
        WHERE ur.SecRoleId = :roleId
        """, nativeQuery = true)
    List<Usuarios> findAllByRoleId(@Param("roleId") int roleId);

    //obtener los usuarios conductores disponibles
    @Query(value = """
        SELECT u.*
        FROM SecUser u
        JOIN SecUserRole ur ON ur.SecUserId = u.SecUserId
        JOIN SecRole r      ON r.SecRoleId  = ur.SecRoleId
        WHERE r.SecRoleId = 104
          AND NOT EXISTS (
              SELECT 1
              FROM programacion_distribucion p
              WHERE p.id_conductor    = u.SecUserId
                AND p.fecha_entrega   = :fecha
                AND p.estado_entrega IN (0, 1)
          )
        """, nativeQuery = true)
    List<Usuarios> findConductoresDisponibles(@Param("fecha") LocalDate fecha);


}
