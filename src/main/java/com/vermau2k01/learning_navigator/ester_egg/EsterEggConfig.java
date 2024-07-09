package com.vermau2k01.learning_navigator.ester_egg;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EsterEggConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
