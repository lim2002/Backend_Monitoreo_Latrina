package com.LatrinaCover.monitoreoBackend.Api;


import com.LatrinaCover.monitoreoBackend.Bl.NotasSalidasBl;
import com.LatrinaCover.monitoreoBackend.Dto.NotaSalidaMasterDto;
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
@RequestMapping("/api/v1/notas-salidas")
public class NotasSalidasApi {

    @Autowired
    private NotasSalidasBl notasSalidasBl;

    @GetMapping(path = "/obtener")
    public ResponseEntity<ResponseDto<List<NotaSalidaMasterDto>>> obtenerNotasSalidas() {
        try {
            List<NotaSalidaMasterDto> notasSalidas = notasSalidasBl.seleccionarNotasSalidas();
            return ResponseEntity.ok(new ResponseDto<>(200, notasSalidas, "Notas de salida obtenidas correctamente"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al obtener las notas de salida"));
        }
    }
}
