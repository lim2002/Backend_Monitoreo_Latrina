package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.SalidasProgramadasBl;
import com.LatrinaCover.monitoreoBackend.Dto.NotaSalidaMasterAddDto;
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
@RequestMapping("/api/v1/salidas-programadas")
public class SalidasProgramadasApi {

    @Autowired
    private SalidasProgramadasBl salidasProgramadasBl;

    //agregar las salidas programadas
    @PostMapping(path = "/add/{idProgramacion}")
    public ResponseEntity<ResponseDto<String>> addSalidasProgramadas(@PathVariable Integer idProgramacion, @RequestBody List<NotaSalidaMasterAddDto> notaSalidaMasterAddDtos) {
        try {
            salidasProgramadasBl.agregarSalidasProgramadasYDetalle(idProgramacion, notaSalidaMasterAddDtos);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Salidas programadas agregadas"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al agregar salidas programadas"));
        }
    }


}
