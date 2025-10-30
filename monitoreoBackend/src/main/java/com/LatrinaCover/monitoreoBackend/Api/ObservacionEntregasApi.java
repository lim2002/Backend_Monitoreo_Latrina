package com.LatrinaCover.monitoreoBackend.Api;


import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
import com.LatrinaCover.monitoreoBackend.Bl.ObservacionEntregasBl;
import com.LatrinaCover.monitoreoBackend.Dto.ObservacionEntregasDto;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
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
@RequestMapping("/api/v1/observacion-entregas")
public class ObservacionEntregasApi {

    @Autowired
    private ObservacionEntregasBl observacionEntregasBl;

    @Autowired
    private AuthBl authBl;

    //mostrar las observaciones por id de programacion salida
    @GetMapping(path = "/programacion-salida/{id}")
    public ResponseEntity<ResponseDto<List<ObservacionEntregasDto>>> getObservacionesByProgramacionSalidaId( @PathVariable Integer id, @RequestHeader ("Authorization") String auth) {
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
            List<ObservacionEntregasDto> observaciones = observacionEntregasBl.getObservacionesByProgramacionSalidaId(id);
            return ResponseEntity.ok(new ResponseDto<>(200, observaciones, "Observaciones obtenidas"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al cargar observaciones"));
        }
    }

    //obtener una observacion por idSalidaDetalle
    @GetMapping(path = "/salida-detalle/{id}")
    public ResponseEntity<ResponseDto<ObservacionEntregasDto>> getObservacionBySalidaDetalleId( @PathVariable Integer id, @RequestHeader ("Authorization") String auth) {
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
            ObservacionEntregasDto observacion = observacionEntregasBl.getObservacionByIdSalidaProgramadaDetalle(id);
            return ResponseEntity.ok(new ResponseDto<>(200, observacion, "Observacion obtenida"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al cargar observacion"));
        }
    }

    //guardar una observacion
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDto<ObservacionEntregasDto>> saveObservacion(@RequestBody ObservacionEntregasDto observacionDto, @RequestHeader ("Authorization") String auth) {
        AuthBl.AuthzResult az = authBl.validateAndAuthorize(
                auth,
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
            observacionEntregasBl.saveObservacion(observacionDto);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Observacion guardada"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al guardar observacion"));
        }
    }
}
