package com.vermau2k01.learning_navigator.ester_egg;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class EsterEggResponse {

    private String fact;
    private boolean success;
    private HttpStatus status;
}
