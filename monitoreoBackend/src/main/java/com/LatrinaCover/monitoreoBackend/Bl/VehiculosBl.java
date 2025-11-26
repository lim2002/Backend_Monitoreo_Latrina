package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.VehiculosDto;
import com.LatrinaCover.monitoreoBackend.Entity.DispositivosGps;
import com.LatrinaCover.monitoreoBackend.Entity.Vehiculos;
import com.LatrinaCover.monitoreoBackend.Repository.DispositivosGpsRepository;
import com.LatrinaCover.monitoreoBackend.Repository.VehiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculosBl {

    @Autowired
    private VehiculosRepository vehiculosRepository;

    @Autowired
    private DispositivosGpsRepository dispositivosGpsRepository;

    //mostrar todos los vehiculos
    public Page<VehiculosDto> getAllVehiculos(String placaOrModelo, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size);


        Page<Vehiculos> vehiculosPage;

        if ("all".equalsIgnoreCase(placaOrModelo)) {
            vehiculosPage = vehiculosRepository.findAllVehiculos(pageable);
        } else {
            vehiculosPage = vehiculosRepository.findAllOrFilterByPlacaOrModelo(placaOrModelo, pageable);
        }

        List<VehiculosDto> vehiculosDto = new ArrayList<>(vehiculosPage.getContent().size());

        for (Vehiculos vehiculo : vehiculosPage.getContent()) {
            vehiculosDto.add(new VehiculosDto(
                    vehiculo.getIdVehiculo(),
                    vehiculo.getDispositivo().getIdDispositivo(),
                    vehiculo.getMarca(),
                    vehiculo.getPlaca(),
                    vehiculo.getModelo(),
                    vehiculo.getAnio(),
                    vehiculo.getCapacidadKg(),
                    vehiculo.getEstadoVehiculo(),
                    vehiculo.getFechaUltimoMantenimiento(),
                    vehiculo.getStatus()
            ));
        }

        // devolver Page<VehiculosDto> manteniendo totalElements y paginación
        return new PageImpl<>(vehiculosDto, pageable, vehiculosPage.getTotalElements());
    }

    //obtener todos lo vehiculos disponibles para entrega
    public List<VehiculosDto> getDisponiblesPorFecha(LocalDate fecha){
        List<Vehiculos> vehiculos = vehiculosRepository.findDisponiblesParaProgramar(fecha);
        List<VehiculosDto> out = new ArrayList<>();
        for (Vehiculos v : vehiculos) {
            out.add(new VehiculosDto(
                    v.getIdVehiculo(),
                    v.getDispositivo().getIdDispositivo(),
                    v.getPlaca(),
                    v.getMarca(),
                    v.getModelo(),
                    v.getAnio(),
                    v.getCapacidadKg(),
                    v.getEstadoVehiculo(),
                    v.getFechaUltimoMantenimiento(),
                    v.getStatus()
            ));
        }
        return out;
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

        DispositivosGps dispositivoActualizado = dispositivosGpsRepository.findByIdDispositivoGps(vehiculoDto.getIdDispositivoGps());
        dispositivoActualizado.setActivo(2); // 2=asignado a un vehiculo
        dispositivosGpsRepository.save(dispositivoActualizado);
    }

    // Modificar vehiculo
    public void updateVehiculo(VehiculosDto vehiculoDto){
        Vehiculos vehiculo = vehiculosRepository.findByIdVehiculo(vehiculoDto.getIdVehiculo());
        vehiculo.setPlaca(vehiculoDto.getPlaca());
        vehiculo.setMarca(vehiculoDto.getMarca());
        vehiculo.setModelo(vehiculoDto.getModelo());
        vehiculo.setAnio(vehiculoDto.getAnio());
        vehiculo.setCapacidadKg(vehiculoDto.getCapacidadKg());
        vehiculo.setEstadoVehiculo(vehiculoDto.getEstadoVehiculo());
        vehiculo.setFechaUltimoMantenimiento(vehiculoDto.getFechaUltimoMantenimiento());
        vehiculosRepository.save(vehiculo);
    }

    //Eliminar vehiculo (status 0)
    public void deleteVehiculo(Integer idVehiculo){
        Vehiculos vehiculo = vehiculosRepository.findByIdVehiculo(idVehiculo);
        vehiculo.setStatus(0); // 0=eliminado
        vehiculosRepository.save(vehiculo);
        //obtener el id del dispositivo gps asignado al vehiculo
        Integer idDispositivoGps = vehiculosRepository.findIdDispositivoByIdVehiculo(idVehiculo);
        DispositivosGps dispositivoActualizado = dispositivosGpsRepository.findByIdDispositivoGps(idDispositivoGps);
        dispositivoActualizado.setActivo(1); // 1=disponible ; 2=asignado a un vehiculo; 0=eliminado
        dispositivosGpsRepository.save(dispositivoActualizado);

    }


}
