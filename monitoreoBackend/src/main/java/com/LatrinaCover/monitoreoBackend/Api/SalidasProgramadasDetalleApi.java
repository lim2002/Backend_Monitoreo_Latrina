package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
import com.LatrinaCover.monitoreoBackend.Bl.SalidasProgramadasDetalleBl;
import com.LatrinaCover.monitoreoBackend.Dto.ConfirmarEntregasDto;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
import com.LatrinaCover.monitoreoBackend.Dto.SalidasProgramadasDetalleDto;
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
@RequestMapping("/api/v1/salidas-programadas-detalle")
public class SalidasProgramadasDetalleApi {

    @Autowired
    private SalidasProgramadasDetalleBl salidasProgramadasDetalleBl;

    @Autowired
    private AuthBl authBl;

    //obtener detalles de salidas programadas por id de salida programada
    @GetMapping(path = "/salida-programada/{idSalidaProgramada}")
    public ResponseEntity<ResponseDto<List<SalidasProgramadasDetalleDto>>> getSalidasProgramadasDetalleByIdSalidaProgramada(@PathVariable Integer idSalidaProgramada, @RequestHeader ("Authorization") String auth) {
        // Lógica para validar el token y la autorización (omitir por brevedad)
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
            // Aquí se llamaría al servicio para obtener los detalles
            List<SalidasProgramadasDetalleDto> detalles = salidasProgramadasDetalleBl.getByIdSalidaProgramada(idSalidaProgramada);
            return ResponseEntity.ok(new ResponseDto<>(200, detalles, "Detalles de salidas programadas encontrados"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener detalles de salidas programadas"));
        }
    }

    //confirmar salidas porgramadas detalle por idSalidaProgramada
    @PostMapping(path = "/confirmar/{idSalidaProgramada}")
    public ResponseEntity<ResponseDto<String>> confirmarSalidasProgramadasDetalle(@PathVariable Integer idSalidaProgramada, @RequestBody List<ConfirmarEntregasDto> confirmarEntregasDtos, @RequestHeader ("Authorization") String auth) {
        // Lógica para validar el token y la autorización (omitir por brevedad)
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
            // Aquí se llamaría al servicio para confirmar los detalles
            salidasProgramadasDetalleBl.confirmarSalidasProgramadasDetalle(idSalidaProgramada, confirmarEntregasDtos);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Detalles de salidas programadas confirmados"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al confirmar detalles de salidas programadas"));
        }
    }



}
