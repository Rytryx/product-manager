package ch.csbe.backendlb.resources.user.authentifikation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    // Configure the security filter chain for your application.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Add the JWT request filter before the UsernamePasswordAuthenticationFilter.
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable();
        http
                .httpBasic().disable() // Disable HTTP Basic authentication.
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/users/login").permitAll()
                        .requestMatchers("/users/register").permitAll()
                        .requestMatchers("/swagger-ui/index.html").permitAll()
                        .requestMatchers("/swagger-ui/*").permitAll()
                        .requestMatchers("/v3/api-docs").permitAll()
                        .requestMatchers("/v3/api-docs/swagger-config").permitAll()
                        .anyRequest().authenticated() // Require authentication for any request.
                );
        return http.build(); // Build and return the security filter chain.
    }
}
