package ch.csbe.backendlb.resources.user.authentifikation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;

/**
 * Configuration class for OpenAPI documentation.
 */
public class OpenApiConfig {

    /**
     * Define a custom OpenAPI configuration.
     *
     * @return The custom OpenAPI configuration.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";

        // Create a new OpenAPI instance.
        return new OpenAPI()
                // Add a security requirement for the "bearerAuth" security scheme.
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                // Define security schemes.
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                // Specify the security scheme type as HTTP with "bearer" scheme.
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                );
    }
}
