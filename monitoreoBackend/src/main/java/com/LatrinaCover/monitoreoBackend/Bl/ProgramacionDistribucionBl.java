package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.ProgramacionDistribucionDto;
import com.LatrinaCover.monitoreoBackend.Dto.ProgramacionDistribucionLecturaDto;
import com.LatrinaCover.monitoreoBackend.Dto.UsuariosDto;
import com.LatrinaCover.monitoreoBackend.Dto.VehiculosDto;
import com.LatrinaCover.monitoreoBackend.Entity.ProgramacionDistribucion;
import com.LatrinaCover.monitoreoBackend.Entity.Usuarios;
import com.LatrinaCover.monitoreoBackend.Entity.Vehiculos;
import com.LatrinaCover.monitoreoBackend.Repository.ProgramacionDistribucionRepository;
import com.LatrinaCover.monitoreoBackend.Repository.UsuariosRepository;
import com.LatrinaCover.monitoreoBackend.Repository.VehiculosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramacionDistribucionBl {

    @Autowired
    private ProgramacionDistribucionRepository programacionDistribucionRepository;

    @Autowired
    private VehiculosRepository vehiculosRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    //metodos de programacion de distribucion

    //agregar programacion de distribucion
    @Transactional
    public ProgramacionDistribucionDto addProgramacionDistribucion(ProgramacionDistribucionDto dto) {

        // Traer referencias administradas (proxy) por id
        Vehiculos vehiculo   = vehiculosRepository.getReferenceById(dto.getIdVehiculo());
        Usuarios  conductor  = usuariosRepository.getReferenceById(dto.getIdConductor());
        Usuarios  admin      = usuariosRepository.getReferenceById(dto.getIdAdministrador());

        ProgramacionDistribucion p = new ProgramacionDistribucion();
        p.setVehiculo(vehiculo);
        p.setConductor(conductor);
        p.setAdministrador(admin);
        p.setFechaCreacion(dto.getFechaCreacion() != null ? dto.getFechaCreacion() : java.time.LocalDateTime.now());
        p.setEstadoEntrega(0);
        p.setFechaEntrega(dto.getFechaEntrega());
        p.setStatus(1);

        p = programacionDistribucionRepository.save(p);

        dto.setIdProgramacion(p.getIdProgramacion());
        dto.setEstadoEntrega(p.getEstadoEntrega());
        return dto;
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

    //Mostrar todas la programacion de dsitribucion
    @Transactional
    public List<ProgramacionDistribucionLecturaDto> getAllProgramacionDistribucion(
            Integer nro, LocalDate desde, LocalDate hasta) {

        List<ProgramacionDistribucion> list =
                programacionDistribucionRepository.findAllByIdAndFecha(nro, desde, hasta);

        return list.stream()
                .map(p -> new ProgramacionDistribucionLecturaDto(
                        p.getIdProgramacion(),
                        p.getVehiculo(),         // se convierte a VehiculosDto adentro
                        p.getConductor(),        // se convierte a UsuariosDto adentro
                        p.getAdministrador(),    // se convierte a UsuariosDto adentro
                        p.getFechaCreacion(),
                        p.getEstadoEntrega(),
                        p.getFechaEntrega(),
                        p.getStatus()
                ))
                .toList();
    }

    //Mostrar todas la programacion de dsitribucion por conductor
    @Transactional
    public List<ProgramacionDistribucionLecturaDto> getAllProgramacionDistribucionByConductor(
            Integer idConductor, Integer nro, LocalDate desde, LocalDate hasta) {

        List<ProgramacionDistribucion> list =
                programacionDistribucionRepository.findAllByConductorRequiredAndFecha(idConductor, nro, desde, hasta);

        return list.stream()
                .map(p -> new ProgramacionDistribucionLecturaDto(
                        p.getIdProgramacion(),
                        p.getVehiculo(),         // se convierte a VehiculosDto adentro
                        p.getConductor(),        // se convierte a UsuariosDto adentro
                        p.getAdministrador(),    // se convierte a UsuariosDto adentro
                        p.getFechaCreacion(),
                        p.getEstadoEntrega(),
                        p.getFechaEntrega(),
                        p.getStatus()
                ))
                .toList();
    }

    //confirmar la programacion de distribucion (estado 2)
    public void confirmProgramacionDistribucion(Integer idProgramacionDistribucion) {
        ProgramacionDistribucion programacionDistribucion = programacionDistribucionRepository.findByIdProgramacion(idProgramacionDistribucion);
        programacionDistribucion.setEstadoEntrega(2);
        programacionDistribucionRepository.save(programacionDistribucion);
    }


    //eliminar programacion de distribucion (status 0)
    public void deleteProgramacionDistribucion(Integer idProgramacionDistribucion) {
        ProgramacionDistribucion programacionDistribucion = new ProgramacionDistribucion();
        programacionDistribucion.setIdProgramacion(idProgramacionDistribucion);
        programacionDistribucion.setStatus(0);

        programacionDistribucionRepository.save(programacionDistribucion);
    }


}
