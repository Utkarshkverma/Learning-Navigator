package com.vermau2k01.learning_navigator.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private String message;
    private Boolean success;
    private HttpStatus httpStatus;
}
