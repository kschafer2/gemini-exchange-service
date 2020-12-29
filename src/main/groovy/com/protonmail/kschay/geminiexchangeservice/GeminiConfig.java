package com.protonmail.kschay.geminiexchangeservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableConfigurationProperties(GeminiProperties.class)
public class GeminiConfig {

    private final GeminiProperties geminiProperties;

    public GeminiConfig(GeminiProperties geminiProperties) {
        this.geminiProperties = geminiProperties;
    }

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }

    @Bean
    public Mac mac() {
        try {
            final Mac mac = Mac.getInstance("HmacSHA384");
            final String secret = System.getenv(geminiProperties.getAuthSecret());
            final SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA384");
            mac.init(secretKeySpec);
            return mac;
        }
        catch (Exception e) {
            throw new RuntimeException("Failure while converting to HMac SHA256",e);
        }
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
