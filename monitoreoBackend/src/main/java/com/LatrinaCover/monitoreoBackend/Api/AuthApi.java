package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
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
@RequestMapping("/api/v1/auth")
public class AuthApi {

    @Autowired
    private AuthBl authBl;

    // autenticarse
    @GetMapping(path = "/login/{id}/{role}/{llave}")
    public ResponseEntity<ResponseDto<String>> login(@PathVariable Integer id, @PathVariable Integer role, @PathVariable String llave) {
        try {
            if (!"latrina2025".equals(llave)) {
                return ResponseEntity.status(401).body(new ResponseDto<>(401, null, "Llave de autenticación incorrecta"));
            }
            String token = authBl.authenticate(id, role);
            return ResponseEntity.ok(new ResponseDto<>(200, token, "Autenticación exitosa"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error en la autenticación"));
        }
    }
}
