package ru.baldursgate3.tgbot.storeservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.baldursgate3.tgbot.storeservice.exceptions.ErrorResponse;
import ru.baldursgate3.tgbot.storeservice.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(UserNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
    }
}
