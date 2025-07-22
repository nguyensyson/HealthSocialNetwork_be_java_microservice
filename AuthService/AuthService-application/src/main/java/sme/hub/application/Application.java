package sme.hub.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@ComponentScan(basePackages = {"sme.hub.*"})
@EnableMethodSecurity
@EnableFeignClients(basePackages = "sme.hub")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}