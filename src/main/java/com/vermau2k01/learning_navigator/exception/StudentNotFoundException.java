package com.vermau2k01.learning_navigator.exception;

import java.util.UUID;

public class StudentNotFoundException  extends RuntimeException {

    String id;

    public StudentNotFoundException(String id) {
        super(String.format("User not found with id : %s",id));

    }
}
