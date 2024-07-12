package com.vermau2k01.learning_navigator.exception;

public class CourseNotExistWithNameException extends  RuntimeException{

    String name;
    public CourseNotExistWithNameException(String name){
        super(String.format("No course exist with name %s so you cannot register the exams for it",name));
    }
}
