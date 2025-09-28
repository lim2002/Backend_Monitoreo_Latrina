package com.LatrinaCover.monitoreoBackend.Bl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class AuthBl {

    private final String SECRET_KEY = "latrina2025";

    //autenticarse desde el sistema comercial
    // 32+ chars (ejemplo). Idealmente muévelo a application.properties/variables de entorno
    private static final String SECRET = "latrina2025-super-secreto-de-32-caracteres-minimo";
    private static final long EXP_3_HOURS_MS = 3L * 60 * 60 * 1000; // 3 horas

    public String authenticate(Integer id, Integer role) {
        return generateToken(id, role);
    }

    private String generateToken(Integer id, Integer role) {
        long now = System.currentTimeMillis();
        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .claim("ID", id)
                .claim("ROLE", role)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + EXP_3_HOURS_MS))
                .signWith(key, SignatureAlgorithm.HS256) // 0.11.x
                .compact();
    }



}
