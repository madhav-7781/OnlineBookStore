package com.example.OnlineBookStore.JWTService;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtility {
    private static final String privateKey = "private";
    private static final long expiration_time = 1000*60*60;

    public String generateToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis()+expiration_time))
                .sign(Algorithm.HMAC256(privateKey));
    }

    public String extractUsername(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(privateKey))
                .build()
                .verify(token);
        return decodedJWT.getSubject();
    }

    public boolean validationOfToken(String token, UserDetails userDetails) {
        try {
            String extractedUsername = extractUsername(token);
            return extractedUsername.equals(userDetails.getUsername());
        } catch (Exception e) {
            return false;
        }
    }
}
