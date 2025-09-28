package com.LatrinaCover.monitoreoBackend.Repository;

import com.LatrinaCover.monitoreoBackend.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario

    //obtener cliente por su codigo
    @Query("SELECT c FROM Clientes c WHERE c.idCliente = ?1" )
    public Clientes findClienteByCodigo(Integer codigo);
}
