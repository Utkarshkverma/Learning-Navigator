package com.vermau2k01.learning_navigator.ester_egg;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hidden-feature")
public class FeatureController {

    private final ApiClient apiClient;

    public FeatureController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping("/{number}")
    public ResponseEntity<EsterEggResponse> getFact(@PathVariable int number) {

        String fact = apiClient.getFact(number);
        EsterEggResponse response = new EsterEggResponse();
        response.setFact(fact);
        response.setSuccess(true);
        response.setStatus(HttpStatus.FOUND);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
