package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.ProgramacionDistribucionDto;
import com.LatrinaCover.monitoreoBackend.Dto.ProgramacionDistribucionLecturaDto;
import com.LatrinaCover.monitoreoBackend.Dto.UsuariosDto;
import com.LatrinaCover.monitoreoBackend.Dto.VehiculosDto;
import com.LatrinaCover.monitoreoBackend.Entity.ProgramacionDistribucion;
import com.LatrinaCover.monitoreoBackend.Entity.Usuarios;
import com.LatrinaCover.monitoreoBackend.Entity.Vehiculos;
import com.LatrinaCover.monitoreoBackend.Repository.ProgramacionDistribucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramacionDistribucionBl {

    @Autowired
    private ProgramacionDistribucionRepository programacionDistribucionRepository;

    //metodos de programacion de distribucion

    //agregar programacion de distribucion
    public void addProgramacionDistribucion(ProgramacionDistribucionDto programacionDistribucionDto) {
        ProgramacionDistribucion programacionDistribucion = new ProgramacionDistribucion();
        Vehiculos vehiculo = new Vehiculos();
        Usuarios conductor = new Usuarios();
        Usuarios Administrador = new Usuarios();
        vehiculo.setIdVehiculo(programacionDistribucionDto.getIdVehiculo().getIdVehiculo());
        conductor.setIdUsuario(programacionDistribucionDto.getIdConductor().getIdUsuario());
        Administrador.setIdUsuario(programacionDistribucionDto.getIdAdministrador().getIdUsuario());
        programacionDistribucion.setVehiculo(vehiculo);
        programacionDistribucion.setConductor(conductor);
        programacionDistribucion.setAdministrador(Administrador);
        programacionDistribucion.setFechaCreacion(programacionDistribucionDto.getFechaCreacion());
        programacionDistribucion.setEstadoEntrega(0); // 0=pendiente, 1=en proceso, 2=entregado
        programacionDistribucion.setFechaEntrega(programacionDistribucionDto.getFechaEntrega());
        programacionDistribucion.setStatus(1);
        programacionDistribucionRepository.save(programacionDistribucion);
    }

    //Ver las programacion de distribucion desde 01/08/2025
    public List<ProgramacionDistribucionLecturaDto> getProgramacionDistribucion(){
        List<ProgramacionDistribucion> programacionDistribucionList = programacionDistribucionRepository.findAll();
        List<ProgramacionDistribucionLecturaDto> programacionDistribucionLecturaDtos = new ArrayList<>();
        for (ProgramacionDistribucion programacionDistribucion : programacionDistribucionList) {
            programacionDistribucionLecturaDtos.add(new ProgramacionDistribucionLecturaDto(
                    programacionDistribucion.getIdProgramacion(),
                    programacionDistribucion.getVehiculo(),
                    programacionDistribucion.getConductor(),
                    programacionDistribucion.getAdministrador(),
                    programacionDistribucion.getFechaCreacion(),
                    programacionDistribucion.getEstadoEntrega(),
                    programacionDistribucion.getFechaEntrega(),
                    programacionDistribucion.getStatus()
            ));
        }
        return programacionDistribucionLecturaDtos;
    }



    //eliminar programacion de distribucion (status 0)
    public void deleteProgramacionDistribucion(Integer idProgramacionDistribucion) {
        ProgramacionDistribucion programacionDistribucion = new ProgramacionDistribucion();
        programacionDistribucion.setIdProgramacion(idProgramacionDistribucion);
        programacionDistribucion.setStatus(0);
        programacionDistribucionRepository.save(programacionDistribucion);
    }


}
