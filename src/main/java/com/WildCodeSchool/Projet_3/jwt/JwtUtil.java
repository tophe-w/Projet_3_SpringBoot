package com.WildCodeSchool.Projet_3.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.WildCodeSchool.Projet_3.dto.UserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;







@Service
public class JwtUtil {

  
  
  Dotenv dotenv = Dotenv.load();


  private Key getKey() {
    byte[] keyBytes = Decoders.BASE64.decode(dotenv.get("SPRING_DATA_SECRET_KEY"));
    // La clé doit faire 256bits
    Key key = Keys.hmacShaKeyFor(keyBytes);
    return key;
  }

  private String createToken(Map<String, Object> claims, String subject) {
    return Jwts
        .builder()
        .setClaims(claims)
        .setSubject(subject)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() +
            1000 * 60 * 60 * 10))
        .signWith(getKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public String generateToken(UserDto userDetails) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("role", userDetails.getRole().toString());
    return createToken(claims, userDetails.getUsername());
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  private Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public Boolean validateToken(String token,
      UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) &&
        !isTokenExpired(token));
  }
  
}



