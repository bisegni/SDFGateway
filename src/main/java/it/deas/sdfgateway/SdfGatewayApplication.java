package it.deas.sdfgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("it.deas")
public class SdfGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SdfGatewayApplication.class, args);
    }
}
