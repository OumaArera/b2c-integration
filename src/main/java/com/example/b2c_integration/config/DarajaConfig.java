package com.example.b2c_integration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DarajaConfig {

    @Value("${daraja.consumerKey}")
    private String consumerKey;

    @Value("${daraja.consumerSecret}")
    private String consumerSecret;

    @Value("${daraja.baseUrl}")
    private String baseUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
