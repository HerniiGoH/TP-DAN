package com.tpdan.mspagos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

@Configuration
public class WebClientConfiguration {
    @Bean
    WebClient webClient(Builder webClientBuilder) {
        return webClientBuilder.build();
    }
}
