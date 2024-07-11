package com.vermau2k01.learning_navigator.exception;

public class CourseNotFoundException extends RuntimeException{

    String id;
    public CourseNotFoundException(String id) {
        super(String.format("Course not found with id : %s",id));
    }
}
