package com.clinicaodontologica.app.clinicaodontologica.seguridad.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class UtilidadJwt {

    private String CLAVE_SECRETA = "algunaClave";

    public String extraerUsuario(String token) {
        return extraerUsuarioSolicitado(token);
    }

    public Date extraerExpiracion(String token) {
        return extraerFechaSolicitud(token);
    }

    public Date extraerFechaSolicitud(String token){
        Claims claims = extraerTodasSolicitudes(token);
        return claims.getExpiration();
    }

    public String extraerUsuarioSolicitado(String token){
        Claims claims = extraerTodasSolicitudes(token);
        return claims.getSubject();
    }
    private Claims extraerTodasSolicitudes(String token) {
        return Jwts.parser().setSigningKey(CLAVE_SECRETA).parseClaimsJws(token).getBody();
    }

    public String generarToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return crearToken(claims, userDetails.getUsername());
    }

    private String crearToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(10).toInstant()))
                .signWith(SignatureAlgorithm.HS256, CLAVE_SECRETA).compact();
    }

    public Boolean validarToken(String token, UserDetails userDetails) {
        final String username = extraerUsuario(token);
        return (username.equals(userDetails.getUsername()) && !esTokenExpirado(token));
    }

    private boolean esTokenExpirado(String token) {
        return extraerExpiracion(token).before(new Date());
    }




}
