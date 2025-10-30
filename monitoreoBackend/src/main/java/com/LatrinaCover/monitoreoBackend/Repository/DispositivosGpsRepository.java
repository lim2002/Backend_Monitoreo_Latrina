package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.DispositivosGps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DispositivosGpsRepository extends JpaRepository<DispositivosGps, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario

    //Listado de los dispositivos GPS por estado 1 y por imei o modelo
    @Query("SELECT d FROM DispositivosGps d WHERE d.status = 1 AND (d.codigo LIKE %?1% OR d.modelo LIKE %?1%)" )
    public List<DispositivosGps> findByAll(String q);

    //Listado de los dispositivos GPS por estado 1
    @Query("SELECT d FROM DispositivosGps d WHERE d.status = 1" )
    public List<DispositivosGps> findByStatus();

    //Listado de los dispositivos GPS por estado y activo 1
    @Query("SELECT d FROM DispositivosGps d WHERE d.status = ?1 AND d.activo = ?2" )
    public List<DispositivosGps> findByStatusAndActivo(Integer status, Integer activo);

    //Obtener dispositivo GPS por id
    @Query("SELECT d FROM DispositivosGps d WHERE d.idDispositivo = ?1" )
    public DispositivosGps findByIdDispositivoGps(Integer idDispositivoGps);





}
