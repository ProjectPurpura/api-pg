package org.purpura.apipg.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mongo.api")
public class MongoApiProperties {
    private String baseUrl;
}