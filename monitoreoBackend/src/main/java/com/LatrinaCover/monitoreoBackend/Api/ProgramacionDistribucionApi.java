package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
import com.LatrinaCover.monitoreoBackend.Bl.ProgramacionDistribucionBl;
import com.LatrinaCover.monitoreoBackend.Dto.ProgramacionDistribucionDto;
import com.LatrinaCover.monitoreoBackend.Dto.ProgramacionDistribucionLecturaDto;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/api/v1/programacion-distribucion")
public class ProgramacionDistribucionApi {

    @Autowired
    private ProgramacionDistribucionBl programacionDistribucionBl;

    @Autowired
    private AuthBl authBl;

    //agregar una programacion de distribucion
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDto<ProgramacionDistribucionDto>> addProgramacionDistribucion(@RequestBody ProgramacionDistribucionDto programacionDistribucionDto, @RequestHeader ("Authorization") String auth) {
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
            ProgramacionDistribucionDto nuevaProgramacion = programacionDistribucionBl.addProgramacionDistribucion(programacionDistribucionDto);
            return ResponseEntity.ok(new ResponseDto<>(200, nuevaProgramacion, "Programacion de distribucion agregada"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al agregar programacion de distribucion"));
        }
    }

    //obtener todas la programacion de distribucion
    @GetMapping(path = "/all")
    public ResponseEntity<ResponseDto<Page<ProgramacionDistribucionLecturaDto>>> getAllProgramacionDistribucion(
            @RequestParam(required = false) Integer nro,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate desde,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate hasta,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,
            @RequestHeader ("Authorization") String auth
    ){
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
        // Normalización simple del rango:
        if (desde != null && hasta == null) hasta = desde;
        if (desde == null && hasta != null) desde = hasta;
        Page<ProgramacionDistribucionLecturaDto> programaciones = programacionDistribucionBl.getAllProgramacionDistribucion(nro, desde, hasta, page, size);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, programaciones, "Programacion de distribucion agregada"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al agregar programacion de distribucion"));
        }

    }

    //obtener todas la programacion de distribucion por conductor
    @GetMapping(path = "/all-by-conductor")
    public ResponseEntity<ResponseDto<List<ProgramacionDistribucionLecturaDto>>> getAllProgramacionDistribucionByConductor(
            @RequestParam Integer idConductor,
            @RequestParam(required = false) Integer nro,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate desde,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate hasta,
            @RequestHeader ("Authorization") String auth
    ){
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
        // Normalización simple del rango:
        if (desde != null && hasta == null) hasta = desde;
        if (desde == null && hasta != null) desde = hasta;
        List<ProgramacionDistribucionLecturaDto> programaciones = programacionDistribucionBl.getAllProgramacionDistribucionByConductor(idConductor, nro, desde, hasta);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, programaciones, "Programacion de distribucion agregada"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al agregar programacion de distribucion"));
        }
    }

    //confirmar la programacion de distribucion
    @PostMapping(path = "/confirm/{idProgramacion}")
    public ResponseEntity<ResponseDto<String>> confirmarProgramacionDistribucion(@PathVariable Integer idProgramacion, @RequestHeader ("Authorization") String auth) {
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
            programacionDistribucionBl.confirmProgramacionDistribucion(idProgramacion);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Programacion de distribucion confirmada"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al confirmar programacion de distribucion"));
        }
    }

    @PutMapping(path = "/updateFecha/{idProgramacion}/{nuevaFecha}")
    public ResponseEntity<ResponseDto<String>> actualizarFechaProgramacionDistribucion(
            @PathVariable Integer idProgramacion,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate nuevaFecha,
            @RequestHeader ("Authorization") String auth) {
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
            if (programacionDistribucionBl.updateFechaEntregaProgramacionDistribucion(idProgramacion, nuevaFecha)==true){
                return ResponseEntity.ok(new ResponseDto<>(200, null, "Fecha de programacion de distribucion actualizada"));
            } else {
                return ResponseEntity.ok(new ResponseDto<>(400, null, "No se puede actualizar la fecha. El vehiculo o conductor ya tiene una programacion activa para esa fecha."));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al actualizar fecha de programacion de distribucion"));
        }
    }


    @DeleteMapping(path = "/delete/{idProgramacion}")
    public ResponseEntity<ResponseDto<String>> eliminarProgramacionDistribucion(@PathVariable Integer idProgramacion, @RequestHeader ("Authorization") String auth) {
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
            programacionDistribucionBl.removeProgramacionDistribucionById(idProgramacion);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Programacion de distribucion eliminada"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al eliminar programacion de distribucion"));
        }
    }

    //obtener los datos para los reportes de fecha hasta fecha
    @GetMapping(path = "/report/{desde}/{hasta}")
    public ResponseEntity<ResponseDto<List<ProgramacionDistribucionLecturaDto>>> getAllProgramacionDistribucionForReportBetweenDates(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate desde,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hasta,
            @RequestHeader ("Authorization") String auth
    ){
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
            List<ProgramacionDistribucionLecturaDto> programaciones =
                    programacionDistribucionBl.getAllProgramacionDistribucionForReportBetweenDates(desde, hasta);
            return ResponseEntity.ok(new ResponseDto<>(200, programaciones, "Datos para reporte obtenidos"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al obtener datos para reporte"));
        }
    }

}
