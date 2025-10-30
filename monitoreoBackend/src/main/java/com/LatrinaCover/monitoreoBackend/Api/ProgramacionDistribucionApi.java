package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
import com.LatrinaCover.monitoreoBackend.Bl.ProgramacionDistribucionBl;
import com.LatrinaCover.monitoreoBackend.Dto.ProgramacionDistribucionDto;
import com.LatrinaCover.monitoreoBackend.Dto.ProgramacionDistribucionLecturaDto;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
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
    public ResponseEntity<ResponseDto<List<ProgramacionDistribucionLecturaDto>>> getAllProgramacionDistribucion(
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
        List<ProgramacionDistribucionLecturaDto> programaciones = programacionDistribucionBl.getAllProgramacionDistribucion(nro, desde, hasta);
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
}
