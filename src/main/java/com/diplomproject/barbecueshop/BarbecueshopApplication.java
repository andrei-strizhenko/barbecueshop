package com.diplomproject.barbecueshop;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import javax.servlet.http.HttpServlet;

@Slf4j
@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "BarbecueSHOP", version = "1.0", description = "Интернет-магазин"))
//@SecurityScheme(name = "javainuseapi", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class BarbecueshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarbecueshopApplication.class, args);
        log.info("Swagger-ui run on: http://localhost:9092/swagger-ui/index.html");
    }

}
