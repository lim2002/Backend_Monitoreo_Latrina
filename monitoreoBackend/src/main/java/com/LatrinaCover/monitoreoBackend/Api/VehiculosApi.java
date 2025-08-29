package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.VehiculosBl;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
import com.LatrinaCover.monitoreoBackend.Dto.VehiculosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehiculos")
public class VehiculosApi {

    @Autowired
    private VehiculosBl vehiculosBl;

    //Mostrar todos los vehiculos
    @GetMapping(path = "/")
    public ResponseEntity<ResponseDto<List<VehiculosDto>>> getAllVehiculos() {
        List<VehiculosDto> vehiculos = vehiculosBl.getAllVehiculos();
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, vehiculos, "Vehiculos encontrados"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener vehiculos"));

        }
    }

    //Agregar un vehiculo
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDto<VehiculosDto>> addVehiculo(@RequestBody VehiculosDto vehiculoDto) {
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
    public ResponseEntity<ResponseDto<VehiculosDto>> updateVehiculo(@RequestBody VehiculosDto vehiculoDto) {
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
    public ResponseEntity<ResponseDto<String>> deleteVehiculo(@PathVariable Integer idVehiculo) {
        try {
            vehiculosBl.deleteVehiculo(idVehiculo);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Vehiculo eliminado correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al eliminar vehiculo"));
        }
    }
}
