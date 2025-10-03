package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
import com.LatrinaCover.monitoreoBackend.Bl.VehiculosBl;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
import com.LatrinaCover.monitoreoBackend.Dto.VehiculosDto;
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
@RequestMapping("api/v1/vehiculos")
public class VehiculosApi {

    @Autowired
    private VehiculosBl vehiculosBl;
    @Autowired
    private AuthBl authBl;

    //Mostrar todos los vehiculos
    @GetMapping(path = "/{PlacaOrModelo}")
    public ResponseEntity<ResponseDto<List<VehiculosDto>>> getAllVehiculos(@PathVariable String PlacaOrModelo, @RequestHeader ("Authorization") String auth) {
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

        List<VehiculosDto> vehiculos = vehiculosBl.getAllVehiculos(PlacaOrModelo);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, vehiculos, "Vehiculos encontrados"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener vehiculos"));

        }
    }

    //Mostrar todos los vehiculos disponibles para entrega
    @GetMapping("/disponibles/{fecha}")
    public ResponseEntity<ResponseDto<List<VehiculosDto>>> getDisponiblesPorFecha(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha, @RequestHeader ("Authorization") String auth) {

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

        List<VehiculosDto> vehiculos = vehiculosBl.getDisponiblesPorFecha(fecha);
        try{
            return ResponseEntity.ok(new ResponseDto<>(200, vehiculos, "Vehículos disponibles encontrados"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener vehículos disponibles"));
        }
    }

    //Agregar un vehiculo
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDto<VehiculosDto>> addVehiculo(@RequestBody VehiculosDto vehiculoDto, @RequestHeader ("Authorization") String auth) {
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
            vehiculosBl.saveVehiculo(vehiculoDto);
            return ResponseEntity.ok(new ResponseDto<>(200, vehiculoDto, "Vehiculo agregado correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al agregar vehiculo"));
        }
    }

    //Modificar un vehiculo
    @PutMapping(path = "/update")
    public ResponseEntity<ResponseDto<VehiculosDto>> updateVehiculo(@RequestBody VehiculosDto vehiculoDto, @RequestHeader ("Authorization") String auth) {
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
            vehiculosBl.updateVehiculo(vehiculoDto);
            return ResponseEntity.ok(new ResponseDto<>(200, vehiculoDto, "Vehiculo modificado correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al modificar vehiculo"));
        }
    }

    //Eliminar un vehiculo (cambiar status a 0)
    @DeleteMapping(path = "/delete/{idVehiculo}")
    public ResponseEntity<ResponseDto<String>> deleteVehiculo(@PathVariable Integer idVehiculo, @RequestHeader ("Authorization") String auth) {
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
            vehiculosBl.deleteVehiculo(idVehiculo);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Vehiculo eliminado correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al eliminar vehiculo"));
        }
    }
}
