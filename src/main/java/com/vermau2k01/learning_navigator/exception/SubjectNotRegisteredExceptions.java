package com.vermau2k01.learning_navigator.exception;

public class SubjectNotRegisteredExceptions extends RuntimeException {
    public SubjectNotRegisteredExceptions() {
        super("Subject not registered. Please register the subject first before registering for its exam");
    }
}
