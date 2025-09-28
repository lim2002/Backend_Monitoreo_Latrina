package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.UsuariosDto;
import com.LatrinaCover.monitoreoBackend.Entity.Usuarios;
import com.LatrinaCover.monitoreoBackend.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosBl {

    @Autowired
    private UsuariosRepository usuariosRepository;

    //obtener todos los usuarios conductores disponibles
    public List<UsuariosDto> getAllConductoresDisponibles(LocalDate fecha){
        List<UsuariosDto> conductores = new ArrayList<>();
        List<Usuarios> usuarios = usuariosRepository.findConductoresDisponibles(fecha);
        for (Usuarios usuario : usuarios) {
            conductores.add(new UsuariosDto(usuario.getIdUsuario(), usuario.getUsername(), usuario.getNombreCompleto(), usuario.getCorreo(), usuario.getCelular(), usuario.getDireccion(), usuario.getFechaNacimiento(), usuario.getNroLicencia(), usuario.getCategoria(),usuario.getFechaExpiracionLicencia()));
        }
        return conductores;
    }

}
