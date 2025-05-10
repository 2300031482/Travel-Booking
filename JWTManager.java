package klu.model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTManager {

    // Secret key for signing JWT tokens (make sure to store it securely)
    private static final String SEC_KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"; // At least 32 bytes
    private final SecretKey key = Keys.hmacShaKeyFor(SEC_KEY.getBytes());

    // Method to generate a JWT token
    public String generateToken(String email) {
        Map<String, String> data = new HashMap<>();
        data.put("email", email);

        // Create the JWT token with the claims (email), issue time, and expiration (1 day)
        return Jwts.builder()
                .setClaims(data)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiry (86400000 milliseconds)
                .signWith(key)
                .compact();
    }

    // Method to validate the token and extract email from it
    public String validateToken(String token) {
        try {
            // Parsing the token using the secret key
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();  // This returns the claims stored in the token

            // Check token expiration
            Date expiry = claims.getExpiration();
            if (expiry == null || expiry.before(new Date())) {
                return "401"; // Token has expired
            }

            // Return the email from the claims
            return claims.get("email", String.class);
        } catch (Exception e) {
            return "401"; // In case of any exception (invalid token, etc.)
        }
    }
}
