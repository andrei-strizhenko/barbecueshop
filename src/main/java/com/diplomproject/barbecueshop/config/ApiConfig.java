package com.diplomproject.barbecueshop.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public OpenAPI barbecueshop () {
        return new OpenAPI()
                .info(new Info()
                        .description("Интернет-магазин BarbecueSHOP")
                        .title("BarbecueSHOP")
                        .version("version 1.0")
                        .contact(new Contact().name("Andrei Str."))
                );
    }
}
