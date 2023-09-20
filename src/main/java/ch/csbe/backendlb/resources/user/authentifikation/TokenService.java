package ch.csbe.backendlb.resources.user.authentifikation;

import ch.csbe.backendlb.resources.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    private final String SECRET_KEY = "yourSecretKey"; // Secret key used for JWT signing

    // Generate a JWT token for the given user.
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail()) // Set the subject (typically user's email) in the token
                .setIssuedAt(new Date(System.currentTimeMillis())) // Set the token's issuance time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Set token expiration time (e.g., 10 hours from now)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Sign the token using HMAC SHA-256 algorithm and the secret key
                .compact(); // Compact and return the token as a string
    }
}
