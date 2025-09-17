package com.LatrinaCover.monitoreoBackend.Bl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class AuthBl {

    private final String SECRET_KEY = "latrina2025";

    //autenticarse desde el sistema comercial
    public String authenticate(Integer id, Integer role) {
        String token = generateToken(id, role);
        return token;
    }

    private String generateToken(Integer id, Integer role) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .claim("ID", id)
                .claim("ROLE", role)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 86400000*3)) // 3 horas de validez
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }



}
