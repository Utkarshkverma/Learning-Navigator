package com.vermau2k01.learning_navigator.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

    @NotNull(message = "Student name cannot be null")
    @NotEmpty(message = "Student name cannot be empty")
    private String name;
}
