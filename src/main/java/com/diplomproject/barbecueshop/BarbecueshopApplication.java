package com.diplomproject.barbecueshop;



import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import javax.servlet.http.HttpServlet;

@Slf4j
@SpringBootApplication

public class BarbecueshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarbecueshopApplication.class, args);
        log.info("Swagger-ui run on: http://localhost:9092/swagger-ui/index.html");
    }

}
