package com.example.tasks.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UniversalExeption.class)
    public ResponseEntity<?> handlerInviteException(UniversalExeption inviteNotFindException){


        return new ResponseEntity<>(new ResponsException(inviteNotFindException.getTitle(),inviteNotFindException.getMessage()), HttpStatus.ACCEPTED);
    }
}
