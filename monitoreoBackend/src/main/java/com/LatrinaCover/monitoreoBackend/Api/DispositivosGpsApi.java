package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
import com.LatrinaCover.monitoreoBackend.Bl.DispositivosGpsBl;
import com.LatrinaCover.monitoreoBackend.Dto.DispositivosGpsDto;
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
@RequestMapping("api/v1/dispositivosGps")
public class DispositivosGpsApi {
    @Autowired
    private DispositivosGpsBl dispositivosGpsBl;

    @Autowired
    private AuthBl authBl;

    //agregar un dispositivo gps
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDto<DispositivosGpsDto>> addDispositivoGps(@RequestBody DispositivosGpsDto dispositivosGpsDto, @RequestHeader ("Authorization") String auth) {

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
            DispositivosGpsDto respuestaDto = dispositivosGpsBl.saveDispositivoGps(dispositivosGpsDto);
            return ResponseEntity.ok(new ResponseDto<>(200, respuestaDto, "Dispositivo GPS agregado correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al agregar dispositivo GPS"));
        }
    }

    //mostrar dispositivos gps disponibles (activo 1 y status 1)
    @GetMapping(path = "/disponibles")
    public ResponseEntity<ResponseDto<List<DispositivosGpsDto>>> getDispositivosGpsDisponibles( @RequestHeader ("Authorization") String auth) {
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
        List<DispositivosGpsDto> dispositivos = dispositivosGpsBl.getDispositivosGpsDisponibles();
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, dispositivos, "Dispositivos GPS disponibles"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener dispositivos GPS disponibles"));
        }
    }

    //mostrar dispositivos gps todos o por imei o modelo
    @GetMapping(path = "/{buscar}")
    public ResponseEntity<ResponseDto<List<DispositivosGpsDto>>> getDispositivosGps(@RequestHeader ("Authorization") String auth, @PathVariable String buscar) {
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
        List<DispositivosGpsDto> dispositivos = dispositivosGpsBl.getDispositivosGps(buscar);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, dispositivos, "Dispositivos GPS "));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener dispositivos GPS "));
        }
    }

    //modificar un dispositivo gps
    @PutMapping(path = "/update")
    public ResponseEntity<ResponseDto<DispositivosGpsDto>> updateDispositivoGps(@RequestBody DispositivosGpsDto dispositivosGpsDto, @RequestHeader ("Authorization") String auth) {
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
            dispositivosGpsBl.updateDispositivoGps(dispositivosGpsDto);
            return ResponseEntity.ok(new ResponseDto<>(200, dispositivosGpsDto, "Dispositivo GPS modificado correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al modificar dispositivo GPS"));
        }
    }

    //eliminar un dispositivo gps (status 0)
    @DeleteMapping(path = "/delete/{idDispositivo}")
    public ResponseEntity<ResponseDto<String>> deleteDispositivoGps(@PathVariable Integer idDispositivo, @RequestHeader ("Authorization") String auth) {
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
            dispositivosGpsBl.deleteDispositivoGps(idDispositivo);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Dispositivo GPS eliminado correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al eliminar dispositivo GPS"));
        }
    }

}
