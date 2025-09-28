package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.UbicacionClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UbicacionClientesRepository extends JpaRepository<UbicacionClientes, Short> {
    // Aquí puedes agregar métodos personalizados si es necesario

    //obtener ubicacion por id de cliente
    @Query("SELECT u FROM UbicacionClientes u WHERE u.cliente.idCliente = ?1")
    public List<UbicacionClientes> findUbicacionByIdCliente(Short idCliente);

    //obtener una ubicacion por su id
    @Query("SELECT u FROM UbicacionClientes u WHERE u.idUbicacionCliente = ?1")
    public UbicacionClientes findByIdUbicacionCliente(Short idUbicacionCliente);


}
