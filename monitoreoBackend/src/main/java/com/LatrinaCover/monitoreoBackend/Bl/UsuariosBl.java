package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.UsuariosDto;
import com.LatrinaCover.monitoreoBackend.Entity.Usuarios;
import com.LatrinaCover.monitoreoBackend.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    //obtener todos los usuarios conductores o filtrar por nombre
    public Page<UsuariosDto> getAllOrByNombreConductores(String q, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Usuarios> usuariosPage = usuariosRepository.findConductoresAllOrByNombre(q, pageable);

        List<UsuariosDto> dtoList = new ArrayList<>();

        for (Usuarios usuario : usuariosPage.getContent()) {
            dtoList.add(new UsuariosDto(
                    usuario.getIdUsuario(),
                    usuario.getUsername(),
                    usuario.getNombreCompleto(),
                    usuario.getCorreo(),
                    usuario.getCelular(),
                    usuario.getDireccion(),
                    usuario.getFechaNacimiento(),
                    usuario.getNroLicencia(),
                    usuario.getCategoria(),
                    usuario.getFechaExpiracionLicencia()
            ));
        }

        return new PageImpl<>(dtoList, pageable, usuariosPage.getTotalElements());
    }


    //obtener usuario por idUsuario
    public UsuariosDto getByIdUsuario(Integer idUsuario){
        Usuarios usuario = usuariosRepository.findByIdUsuario(idUsuario);
        if (usuario != null) {
            return new UsuariosDto(usuario.getIdUsuario(), usuario.getUsername(), usuario.getNombreCompleto(), usuario.getCorreo(), usuario.getCelular(), usuario.getDireccion(), usuario.getFechaNacimiento(), usuario.getNroLicencia(), usuario.getCategoria(),usuario.getFechaExpiracionLicencia());
        } else {
            return null;
        }
    }

    //obtener todos los condutores
    public List<UsuariosDto> getAllConductores(){
        List<UsuariosDto> conductores = new ArrayList<>();
        List<Usuarios> usuarios = usuariosRepository.findAllByRoleId(104); //104 es el id del rol de conductor
        for (Usuarios usuario : usuarios) {
            conductores.add(new UsuariosDto(usuario.getIdUsuario(), usuario.getUsername(), usuario.getNombreCompleto(), usuario.getCorreo(), usuario.getCelular(), usuario.getDireccion(), usuario.getFechaNacimiento(), usuario.getNroLicencia(), usuario.getCategoria(),usuario.getFechaExpiracionLicencia()));
        }
        return conductores;
    }

}
