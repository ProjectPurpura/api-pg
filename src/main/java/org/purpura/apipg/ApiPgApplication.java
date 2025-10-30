package org.purpura.apipg;

import org.purpura.apipg.config.MongoApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(MongoApiProperties.class)
@SpringBootApplication
public class ApiPgApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPgApplication.class, args);
    }

}
