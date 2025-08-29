package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.VehiculosDto;
import com.LatrinaCover.monitoreoBackend.Entity.DispositivosGps;
import com.LatrinaCover.monitoreoBackend.Entity.Vehiculos;
import com.LatrinaCover.monitoreoBackend.Repository.VehiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculosBl {

    @Autowired
    private VehiculosRepository vehiculosRepository;

    //mostrar todos los vehiculos
    public List<VehiculosDto> getAllVehiculos(){
        List<Vehiculos> vehiculos = vehiculosRepository.findAllVehiculos();
        List<VehiculosDto> vehiculosDto = new ArrayList<>();
        for (Vehiculos vehiculo : vehiculos) {
            vehiculosDto.add(new VehiculosDto(vehiculo.getIdVehiculo(), vehiculo.getDispositivo().getIdDispositivo(), vehiculo.getPlaca(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getAnio(), vehiculo.getCapacidadKg(),vehiculo.getEstadoVehiculo(),vehiculo.getFechaUltimoMantenimiento(), vehiculo.getStatus()));
        }
        return vehiculosDto;
    }

    //Guardar vehiculo
    public void saveVehiculo(VehiculosDto vehiculoDto){
        DispositivosGps dispositivo = new DispositivosGps();
        Vehiculos vehiculo = new Vehiculos();
        dispositivo.setIdDispositivo(vehiculoDto.getIdDispositivoGps());
        vehiculo.setDispositivo(dispositivo);
        vehiculo.setPlaca(vehiculoDto.getPlaca());
        vehiculo.setMarca(vehiculoDto.getMarca());
        vehiculo.setModelo(vehiculoDto.getModelo());
        vehiculo.setAnio(vehiculoDto.getAnio());
        vehiculo.setCapacidadKg(vehiculoDto.getCapacidadKg());
        vehiculo.setEstadoVehiculo(vehiculoDto.getEstadoVehiculo());
        vehiculo.setFechaUltimoMantenimiento(vehiculoDto.getFechaUltimoMantenimiento());
        vehiculo.setStatus(1);
        vehiculosRepository.save(vehiculo);
    }

    // Modificar vehiculo
    public void updateVehiculo(VehiculosDto vehiculoDto){
        DispositivosGps dispositivo = new DispositivosGps();
        Vehiculos vehiculo = new Vehiculos();
        dispositivo.setIdDispositivo(vehiculoDto.getIdDispositivoGps());
        vehiculo.setIdVehiculo(vehiculoDto.getIdVehiculo());
        vehiculo.setDispositivo(dispositivo);
        vehiculo.setPlaca(vehiculoDto.getPlaca());
        vehiculo.setMarca(vehiculoDto.getMarca());
        vehiculo.setModelo(vehiculoDto.getModelo());
        vehiculo.setAnio(vehiculoDto.getAnio());
        vehiculo.setCapacidadKg(vehiculoDto.getCapacidadKg());
        vehiculo.setEstadoVehiculo(vehiculoDto.getEstadoVehiculo());
        vehiculo.setFechaUltimoMantenimiento(vehiculoDto.getFechaUltimoMantenimiento());
        vehiculo.setStatus(vehiculoDto.getStatus());
        vehiculosRepository.save(vehiculo);
    }

    //Eliminar vehiculo (status 0)
    public void deleteVehiculo(Integer idVehiculo){
        Vehiculos vehiculo = new Vehiculos();
        vehiculo.setIdVehiculo(idVehiculo);
        vehiculo.setStatus(0);
        vehiculosRepository.save(vehiculo);
    }


}
