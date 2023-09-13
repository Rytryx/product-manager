package ch.csbe.backendlb.resources.user.authentifikation;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class SecurityFilterChain {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .httpBasic().disable()
                .authorizeHttpRequests((authz) -> authz.requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/swagger-ui/index.html").permitAll()
                        .requestMatchers("/swagger-ui/*").permitAll()
                        .requestMatchers("/v3/api-docs").permitAll()
                        .requestMatchers("/v3/api-docs/swagger-config").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}