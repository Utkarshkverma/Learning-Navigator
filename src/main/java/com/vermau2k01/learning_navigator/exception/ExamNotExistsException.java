package com.vermau2k01.learning_navigator.exception;

public class ExamNotExistsException extends RuntimeException {

    String id;
    public ExamNotExistsException(String id) {
        super(String.format("Exam not exists with id : %s",id));
    }
}
