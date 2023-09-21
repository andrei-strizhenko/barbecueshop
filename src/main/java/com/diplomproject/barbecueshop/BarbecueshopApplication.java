package com.diplomproject.barbecueshop;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication

public class BarbecueshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarbecueshopApplication.class, args);
        log.info("Swagger-ui run on: http://https://dashboard.render.com/web/srv-ck60rq8s0i2c73bq7ac0/deploys/dep-ck60rqos0i2c73bq7k4g/swagger-ui/index.html");
    }

}
