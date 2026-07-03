package com.HealthSys.Servico_Usuarios.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final RsaKeyProvider rsaKeyProvider;

    @Value("{jwt.expiration-minutes}")
    private long expirationMinutes;

    public JwtService(RsaKeyProvider rsaKeyProvider) {
        this.rsaKeyProvider = rsaKeyProvider;
    }

    public String gerarToken (UserDetails userDetails) {
        PrivateKey privateKey = rsaKeyProvider.getPrivateKey();

        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        Instant now = Instant.now();
        Instant expiration = now.plus(expirationMinutes, ChronoUnit.MINUTES);

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claim("role", roles)
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiration))
                .signWith(privateKey, Jwts.SIG.ES256)
                .compact();
    }

    public boolean isTokenValido (String token) {
        try {
            extrairTodasClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<String> extrairRoles (String token) {
        return extrairTodasClaims(token).get("roles", List.class);
    }

    public String extrairUsername (String token) {
        return extrairTodasClaims(token).getSubject();
    }

    private Claims extrairTodasClaims (String token) {
        PublicKey publicKey = rsaKeyProvider.getPublicKey();

        Jws<Claims> jws =  Jwts.parser()
                .verifyWith(publicKey)
                .build()
                .parseSignedClaims(token);

        return jws.getPayload();
    }
}
