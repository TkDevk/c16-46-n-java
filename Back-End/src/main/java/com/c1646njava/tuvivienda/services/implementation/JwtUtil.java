package com.c1646njava.tuvivienda.services.implementation;
import com.c1646njava.tuvivienda.models.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    public static String generateToken(User user) {
        String secretKey = "mySecretKey"; // Cambiar por una clave secreta real
        long expirationTime = System.currentTimeMillis() + (1000 * 60 * 60 * 24); // 24 horas

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setExpiration(new Date(expirationTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
    public static boolean validateToken(String token) {
        String secretKey = "mySecretKey"; // Cambiar por una clave secreta real

        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}