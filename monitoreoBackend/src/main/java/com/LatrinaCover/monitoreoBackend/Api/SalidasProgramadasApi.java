package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
import com.LatrinaCover.monitoreoBackend.Bl.SalidasProgramadasBl;
import com.LatrinaCover.monitoreoBackend.Dto.NotaSalidaMasterAddDto;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
import com.LatrinaCover.monitoreoBackend.Dto.SalidasProgramadasDto;
import com.LatrinaCover.monitoreoBackend.Entity.SalidasProgramadas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        originPatterns = "*",           // acepta cualquier origen
        allowCredentials = "false",     // no usamos cookies
        allowedHeaders = { "Authorization", "Content-Type" },
        methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE, RequestMethod.OPTIONS },
        maxAge = 3600
)
@RestController
@RequestMapping("/api/v1/salidas-programadas")
public class SalidasProgramadasApi {

    @Autowired
    private SalidasProgramadasBl salidasProgramadasBl;

    @Autowired
    private AuthBl authBl;

    //agregar las salidas programadas
    @PostMapping(path = "/add/{idProgramacion}")
    public ResponseEntity<ResponseDto<String>> addSalidasProgramadas(@PathVariable Integer idProgramacion, @RequestBody List<NotaSalidaMasterAddDto> notaSalidaMasterAddDtos, @RequestHeader ("Authorization") String auth) {
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

        try {
            salidasProgramadasBl.agregarSalidasProgramadasYDetalle(idProgramacion, notaSalidaMasterAddDtos);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Salidas programadas agregadas"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al agregar salidas programadas"));
        }
    }

    //obtener salidas programadas por id de programacion
    @GetMapping(path = "/{idProgramacion}")
    public ResponseEntity<ResponseDto<List<SalidasProgramadasDto>>> getSalidasProgramadasByIdProgramacion(@PathVariable Integer idProgramacion, @RequestHeader ("Authorization") String auth) {
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

        try {
            List<SalidasProgramadasDto> salidasProgramadas = salidasProgramadasBl.getSalidasProgramadasByIdProgramacion(idProgramacion);
            return ResponseEntity.ok(new ResponseDto<>(200, salidasProgramadas, "Salidas programadas obtenidas"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al obtener salidas programadas"));
        }
    }


}
