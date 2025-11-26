package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    //obtener todos los usuarios conductores
    @Query(value = """
        SELECT DISTINCT u.*
        FROM SecUser u
        JOIN SecUserRole ur ON ur.SecUserId = u.SecUserId
        WHERE ur.SecRoleId = 104
          AND (
                :q IS NULL OR LTRIM(RTRIM(:q)) = ''
                OR UPPER(u.SecUserNameFill) LIKE UPPER(CONCAT('%', :q, '%'))
          )
        ORDER BY u.SecUserNameFill
        """,
            countQuery = """
        SELECT COUNT(DISTINCT u.SecUserId)
        FROM SecUser u
        JOIN SecUserRole ur ON ur.SecUserId = u.SecUserId
        WHERE ur.SecRoleId = 104
          AND (
                :q IS NULL OR LTRIM(RTRIM(:q)) = ''
                OR UPPER(u.SecUserNameFill) LIKE UPPER(CONCAT('%', :q, '%'))
          )
        """,
            nativeQuery = true)
    Page<Usuarios> findConductoresAllOrByNombre(@Param("q") String q, Pageable pageable);



    //verificar si el usuario tiene el rol indicado
    @Query(value = """
    SELECT CAST(CASE 
                  WHEN EXISTS (
                      SELECT 1 
                      FROM SecUserRole ur
                      WHERE ur.SecUserId = :idUsuario
                        AND ur.SecRoleId = :roleId
                  ) 
                  THEN 1 ELSE 0 
                END AS BIT) AS hasRole
    """, nativeQuery = true)
    boolean existsByIdUsuarioAndRoleId(@Param("idUsuario") Integer idUsuario, @Param("roleId") Integer roleId);


    //verificar si el usuario conductor no tene programacion de distribucion en la fecha indicada
    @Query(value = """
        SELECT CAST(CASE 
                      WHEN EXISTS (
                          SELECT 1
                          FROM programacion_distribucion p
                          WHERE p.id_conductor    = :idConductor
                            AND p.fecha_entrega   = :fecha
                            AND p.estado_entrega IN (0)
                      ) 
                      THEN 1 ELSE 0 
                    END AS BIT) AS hasProgramacion
        """, nativeQuery = true)
    boolean existsProgramacionByIdConductorAndFecha(@Param("idConductor") Integer idConductor, @Param("fecha") LocalDate fecha);

    @Query(value = """
        SELECT DISTINCT u.*
        FROM SecUser u
        JOIN SecUserRole ur ON ur.SecUserId = u.SecUserId
        WHERE ur.SecRoleId = 104
        ORDER BY u.SecUserNameFill
        """, nativeQuery = true)
    List<Usuarios> findAllConductores(@Param("q") String q);


}
