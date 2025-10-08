package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
import com.LatrinaCover.monitoreoBackend.Bl.UsuariosBl;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
import com.LatrinaCover.monitoreoBackend.Dto.UsuariosDto;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(
        originPatterns = "*",           // acepta cualquier origen
        allowCredentials = "false",     // no usamos cookies
        allowedHeaders = { "Authorization", "Content-Type" },
        methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE, RequestMethod.OPTIONS },
        maxAge = 3600
)
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuariosApi {

    @Autowired
    private UsuariosBl usuariosBl;

    @Autowired
    private AuthBl authBl;

    //obtener todos lo usuarios conductores disponibles
    @GetMapping(path = "/conductores/disponibles/{fecha}")
    public ResponseEntity<ResponseDto<List<UsuariosDto>>> getAllConductoresDisponibles(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha, @RequestHeader ("Authorization") String auth) {
        AuthBl.AuthzResult az = authBl.validateAndAuthorize(
                auth,
                AuthBl.ROLE_ADMINISTRADOR
        );

        if (!az.isTokenValid()) {
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(401, null, "No autorizado: " + az.getMessage()));
        }
        if (!az.isAuthorized()) {
            return ResponseEntity.status(403)
                    .body(new ResponseDto<>(403, null, "Acceso denegado: " + az.getMessage()));
        }

        List<UsuariosDto> usuarios = usuariosBl.getAllConductoresDisponibles(fecha);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, usuarios, "Conductores disponibles encontrados"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener conductores disponibles"));
        }
    }

    //obtener todos los usuarios conductores o filtrar por nombre
    @GetMapping(path = "/conductores/all")
    public ResponseEntity<ResponseDto<List<UsuariosDto>>> getAllOrByNombreConductores(@RequestParam(required = false) String nombre, @RequestHeader ("Authorization") String auth) {
        AuthBl.AuthzResult az = authBl.validateAndAuthorize(
                auth,
                AuthBl.ROLE_ADMINISTRADOR
        );

        if (!az.isTokenValid()) {
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(401, null, "No autorizado: " + az.getMessage()));
        }
        if (!az.isAuthorized()) {
            return ResponseEntity.status(403)
                    .body(new ResponseDto<>(403, null, "Acceso denegado: " + az.getMessage()));
        }

        List<UsuariosDto> usuarios = usuariosBl.getAllOrByNombreConductores(nombre);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, usuarios, "Conductores encontrados"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener conductores"));
        }
    }

    //obtener usuario por idUsuario
    @GetMapping(path = "/{idUsuario}")
    public ResponseEntity<ResponseDto<UsuariosDto>> getByIdUsuario(@RequestHeader("Authorization") String auth, @PathVariable Integer idUsuario) {

        // Autoriza a AMBOS (ADMIN + CONDUCTOR).
        AuthBl.AuthzResult az = authBl.validateAndAuthorize(
                auth,
                AuthBl.ROLE_ADMINISTRADOR,
                AuthBl.ROLE_CONDUCTOR
        );

        if (!az.isTokenValid()) {
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(401, null, "No autorizado: " + az.getMessage()));
        }
        if (!az.isAuthorized()) {
            return ResponseEntity.status(403)
                    .body(new ResponseDto<>(403, null, "Acceso denegado: " + az.getMessage()));
        }

        UsuariosDto usuario = usuariosBl.getByIdUsuario(idUsuario);
        try {
            if (usuario != null) {
                return ResponseEntity.ok(new ResponseDto<>(200, usuario, "Usuario encontrado"));
            } else {
                return ResponseEntity.status(404).body(new ResponseDto<>(404, null, "Usuario no encontrado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener usuario"));
        }
    }

}
