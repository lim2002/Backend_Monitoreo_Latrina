package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.ProgramacionDistribucionBl;
import com.LatrinaCover.monitoreoBackend.Dto.ProgramacionDistribucionDto;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //agregar una programacion de distribucion
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDto<ProgramacionDistribucionDto>> addProgramacionDistribucion(@RequestBody ProgramacionDistribucionDto programacionDistribucionDto) {
        try {
            ProgramacionDistribucionDto nuevaProgramacion = programacionDistribucionBl.addProgramacionDistribucion(programacionDistribucionDto);
            return ResponseEntity.ok(new ResponseDto<>(200, nuevaProgramacion, "Programacion de distribucion agregada"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al agregar programacion de distribucion"));
        }
    }
}
