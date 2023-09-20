package ch.csbe.backendlb.resources.user.authentifikation;

import ch.csbe.backendlb.resources.user.User;
import ch.csbe.backendlb.resources.user.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    // Define your secret key for JWT token. Ensure it is stored securely.
    private final String SECRET_KEY = "yourSecretKey"; // Please ensure that this is securely stored.

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {
        // Retrieve the 'Authorization' header from the HTTP request.
        final String authorizationHeader = request.getHeader("Authorization");
        String email = null;
        String jwt = null;

        // Check if the 'Authorization' header exists and starts with 'Bearer '.
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            // Extract the email from the JWT token using the secret key.
            email = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody().getSubject();
        }

        // If a valid email is found and the user is not authenticated, authenticate the user.
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userService.findUserByEmail(email);
            if (user != null) {
                // Create a user principal and authentication token.
                MyUserPrincipal userPrincipal = new MyUserPrincipal(user);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userPrincipal, null, userPrincipal.getAuthorities()
                );
                // Set the authentication token in the security context.
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        // Continue with the filter chain.
        chain.doFilter(request, response);
    }
}
