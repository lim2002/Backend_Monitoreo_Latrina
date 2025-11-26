package com.LatrinaCover.monitoreoBackend.Api;

import com.LatrinaCover.monitoreoBackend.Bl.AuthBl;
import com.LatrinaCover.monitoreoBackend.Dto.ResponseDto;
import com.LatrinaCover.monitoreoBackend.Repository.UsuariosRepository;
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

    @Autowired
    private UsuariosRepository usuariosRepository;


    // autenticarse
    @GetMapping(path = "/login/{id}/{role}/{llave}")
    public ResponseEntity<ResponseDto<String>> login(@PathVariable Integer id, @PathVariable Integer role, @PathVariable String llave) {
        String URL_ACCESO = "http://127.0.0.1:3000/#token=";
        try {
            if (!"latrina2025".equals(llave)) {
                return ResponseEntity.status(401).body(new ResponseDto<>(401, null, "Llave de autenticación incorrecta"));
            }
            if (usuariosRepository.existsByIdUsuarioAndRoleId(id, role)==true) {
                String token = authBl.authenticate(id, role);
                URL_ACCESO += token;
                return ResponseEntity.ok(new ResponseDto<>(200, URL_ACCESO, "Autenticación exitosa"));
            }else {
                return ResponseEntity.status(403).body(new ResponseDto<>(403, null, "Usuario o rol inválido"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto<>(500, null, "Error en la autenticación"));
        }
    }
}
