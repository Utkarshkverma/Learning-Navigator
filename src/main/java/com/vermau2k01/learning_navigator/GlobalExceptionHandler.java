package com.vermau2k01.learning_navigator;

import com.vermau2k01.learning_navigator.exception.*;
import com.vermau2k01.learning_navigator.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getBindingResult().getFieldError()
                .getDefaultMessage());
        errorResponse.setSuccess(false);
        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> StudentNotFoundExceptionHandler(
            StudentNotFoundException e)
    {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .success(false)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorResponse> CourseNotFoundExceptionHandler(
            StudentNotFoundException e)
    {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .success(false)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(CourseNotExistWithNameException.class)
    public ResponseEntity<ErrorResponse> CourseNotExistWithNameExceptionHandler(
            CourseNotExistWithNameException e
    )
    {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .success(false)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SubjectNotRegisteredExceptions.class)
    public ResponseEntity<ErrorResponse> SubjectNotRegisteredExceptionHandler(
            SubjectNotRegisteredExceptions e
    )
    {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .success(false)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExamNotExistsException.class)
    public ResponseEntity<ErrorResponse> ExamNotExistsExceptionHandler(
            ExamNotExistsException e
    )
    {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .success(false)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }




}
