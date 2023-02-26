package com.diplomproject.barbecueshop.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class ApiConfig {

    @Bean
    public OpenAPI libraryProject() {
        return new OpenAPI()
                .info(new Info()
                        .description("NET Shop")
                        .title("BarbecueSHOP")
                        .version("version 1.0")
                        .contact(new Contact().name("Andrei.Str"))
                );
    }
}


