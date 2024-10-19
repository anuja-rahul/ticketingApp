package org.example.ticketingapp.configuration;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String extractUserEmail(String token) {
        return null;
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignInKey())
                .build()
                .parse(token).getPayload();
    }
}
