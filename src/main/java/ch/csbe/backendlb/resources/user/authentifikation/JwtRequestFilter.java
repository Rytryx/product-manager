package ch.csbe.backendlb.resources.user.authentifikation;

import ch.csbe.backendlb.resources.user.User;
import ch.csbe.backendlb.resources.user.UserService;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    // Schritt 1
    @Autowired
    private UserService userService;

    private final String SECRET_KEY = "yourSecretKey";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {
        // Schritt 2
        final String authorizationHeader = request.getHeader("Authorization");

        String email = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            email = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody().getSubject();
        }

        // Schritt 3
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userService.findUserByEmail(email);
            MyUserPrincipal userPrincipal = new MyUserPrincipal(user);
            userPrincipal.setEmail(user.getEmail());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
            // Schritt 4
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        chain.doFilter(request, response);
    }
}

