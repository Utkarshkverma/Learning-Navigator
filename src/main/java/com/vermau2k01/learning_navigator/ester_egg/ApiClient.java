package com.vermau2k01.learning_navigator.ester_egg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiClient {

    private final RestTemplate restTemplate;
    private final String url;

    public ApiClient(RestTemplate restTemplate,@Value("${numbers.api.base-url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public String getFact(int number) {
        String web = url + "/" + number;
        return restTemplate.getForObject(web, String.class);
    }
}
