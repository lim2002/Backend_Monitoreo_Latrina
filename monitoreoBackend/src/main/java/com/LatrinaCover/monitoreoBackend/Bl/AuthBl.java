package com.LatrinaCover.monitoreoBackend.Bl;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Objects;
import java.util.stream.IntStream;

@Service
public class AuthBl {

    // === Mueve esto a application.properties o variables de entorno ===
    // Debe ser la MISMA clave que usas para firmar y de ≥32 chars
    private static final String SECRET = "latrina20258-sdhfjdshjrsoskjfssdfhsdfhjsdfh";
    private static final long EXP_3_HOURS_MS = 8L * 60 * 60 * 1000; // 3 horas
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    // === Roles (ajusta el id real de ADMINISTRADOR a tu SecRoleId) ===
    public static final int ROLE_CONDUCTOR      = 104;
    public static final int ROLE_ADMINISTRADOR  = 2; // TODO: reemplaza por el SecRoleId real de ADMIN

    // -------------------- GENERACIÓN (igual que tenías) --------------------
    public String authenticate(Integer id, Integer role) {
        return generateToken(id, role);
    }

    private String generateToken(Integer id, Integer role) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .claim("ID", id)
                .claim("ROLE", role)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + EXP_3_HOURS_MS))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // -------------------- VALIDACIÓN + AUTORIZACIÓN --------------------
    public AuthzResult validateAndAuthorize(String authHeader, int... allowedRoles) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return AuthzResult.invalid("Falta encabezado Authorization o formato Bearer inválido");
        }

        final String token = authHeader.substring(7).trim();
        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            Claims claims = jws.getBody();
            Integer userId = claims.get("ID", Integer.class);
            Integer role   = claims.get("ROLE", Integer.class);

            if (userId == null || role == null) {
                return AuthzResult.invalid("Claims incompletos (ID o ROLE faltantes)");
            }

            boolean roleAllowed =
                    (allowedRoles == null || allowedRoles.length == 0) // si no pasas nada => cualquier rol
                            || IntStream.of(allowedRoles).anyMatch(r -> Objects.equals(r, role));

            if (!roleAllowed) {
                return AuthzResult.forbidden(userId, role, "Rol no autorizado para este endpoint");
            }
            return AuthzResult.ok(userId, role);

        } catch (ExpiredJwtException e) {
            return AuthzResult.invalid("Token expirado");
        } catch (UnsupportedJwtException | MalformedJwtException e) {
            return AuthzResult.invalid("Token inválido");
        } catch (SecurityException e) { // firma
            return AuthzResult.invalid("Firma inválida");
        } catch (IllegalArgumentException e) {
            return AuthzResult.invalid("Token vacío o mal formado");
        }
    }

    // -------------------- Resultado de autorización --------------------
    public static class AuthzResult {
        private final boolean tokenValid;
        private final boolean authorized;
        private final Integer userId;
        private final Integer role;
        private final String  message;

        private AuthzResult(boolean tokenValid, boolean authorized, Integer userId, Integer role, String message) {
            this.tokenValid = tokenValid;
            this.authorized = authorized;
            this.userId = userId;
            this.role = role;
            this.message = message;
        }

        public static AuthzResult ok(Integer userId, Integer role) {
            return new AuthzResult(true, true, userId, role, "Autorizado");
        }
        public static AuthzResult forbidden(Integer userId, Integer role, String msg) {
            return new AuthzResult(true, false, userId, role, msg);
        }
        public static AuthzResult invalid(String msg) {
            return new AuthzResult(false, false, null, null, msg);
        }

        public boolean isTokenValid() { return tokenValid; }
        public boolean isAuthorized() { return authorized; }
        public Integer getUserId() { return userId; }
        public Integer getRole() { return role; }
        public String getMessage() { return message; }
    }



}
