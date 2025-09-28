package com.LatrinaCover.monitoreoBackend.Api;

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

    //agregar un dispositivo gps
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDto<DispositivosGpsDto>> addDispositivoGps(@RequestBody DispositivosGpsDto dispositivosGpsDto) {
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
    public ResponseEntity<ResponseDto<List<DispositivosGpsDto>>> getDispositivosGpsDisponibles() {
        List<DispositivosGpsDto> dispositivos = dispositivosGpsBl.getDispositivosGpsDisponibles();
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, dispositivos, "Dispositivos GPS disponibles"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener dispositivos GPS disponibles"));
        }
    }

    //mostrar dispositivos gps disponibles (activo 1 y status 1)
    @GetMapping(path = "/")
    public ResponseEntity<ResponseDto<List<DispositivosGpsDto>>> getDispositivosGps() {
        List<DispositivosGpsDto> dispositivos = dispositivosGpsBl.getDispositivosGps();
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, dispositivos, "Dispositivos GPS "));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener dispositivos GPS "));
        }
    }

    //modificar un dispositivo gps
    @PutMapping(path = "/update")
    public ResponseEntity<ResponseDto<DispositivosGpsDto>> updateDispositivoGps(@RequestBody DispositivosGpsDto dispositivosGpsDto) {
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
    public ResponseEntity<ResponseDto<String>> deleteDispositivoGps(@PathVariable Integer idDispositivo) {
        try {
            dispositivosGpsBl.deleteDispositivoGps(idDispositivo);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Dispositivo GPS eliminado correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al eliminar dispositivo GPS"));
        }
    }

}
