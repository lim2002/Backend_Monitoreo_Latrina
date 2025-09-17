package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthApi {

    @Autowired
    private AuthBl authBl;

    // autenticarse
    @PostMapping(path = "/login/{id}/{role}/{llave}")
    public ResponseEntity<ResponseDto<String>> login(Integer id, Integer role, String llave) {
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
