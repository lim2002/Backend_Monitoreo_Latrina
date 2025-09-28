package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.UsuariosBl;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
import com.LatrinaCover.monitoreoBackend.Dto.UsuariosDto;
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
@RequestMapping("api/v1/usuarios")
public class UsuariosApi {

    @Autowired
    private UsuariosBl usuariosBl;

    //obtener todos lo usuarios conductores disponibles
    @GetMapping(path = "/conductores/disponibles/{fecha}")
    public ResponseEntity<ResponseDto<List<UsuariosDto>>> getAllConductoresDisponibles(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha) {
        List<UsuariosDto> usuarios = usuariosBl.getAllConductoresDisponibles(fecha);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, usuarios, "Conductores disponibles encontrados"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error al obtener conductores disponibles"));
        }
    }
}
