package com.apipharma.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Service
public class JwtService {

    // WHERE TO Generated https://www.allkeysgenerator.com/
    private final String SECRET_KEY="M631rR_iH3Yp_w5i9a8u0w38770-p1082675171";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject); // get subject okay so because as I mentioned  before the subject is or should be the email o surname
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken( new HashMap<>() , userDetails );
    }


    private String generateToken(
            Map<String, Object> extractClaims,
            UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                //.claim("authorities",userDetails.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*24))
                .signWith(getSignInKey() , SignatureAlgorithm.HS256 )
                .compact();  // generate and return the token
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {   // validate is the token belong to a player
        final String usernameFromToken = extractUsername(token);
        return (usernameFromToken.equals(userDetails.getUsername()) && !isTokenExpired(token)) ;
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration); // extract the expiration date
    }

    private boolean isTokenExpired(String token) {   // verify it the token is expired
        return extractExpiration(token).before(new Date());
    }






    public boolean hasClaim(String token, String claimName){
        final Claims claims= extractAllClaims(token);
        return claims.get(claimName) != null;
    }

















}
