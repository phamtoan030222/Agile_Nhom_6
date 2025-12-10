package com.example.admincrud.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleNotFound(ResourceNotFoundException ex){
    Map<String,Object> body = new HashMap<>();
    body.put("error","NOT_FOUND");
    body.put("message", ex.getMessage());
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex){
    Map<String,Object> body = new HashMap<>();
    body.put("error","VALIDATION_ERROR");
    body.put("message", ex.getBindingResult().getFieldErrors().stream().map(e -> e.getField()+": "+e.getDefaultMessage()).toList());
    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleGeneric(Exception ex){
    Map<String,Object> body = new HashMap<>();
    body.put("error","INTERNAL_ERROR");
    body.put("message", ex.getMessage());
    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
