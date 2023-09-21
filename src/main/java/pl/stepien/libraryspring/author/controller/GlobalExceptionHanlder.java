package pl.stepien.libraryspring.author.controller;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pl.stepien.libraryspring.author.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHanlder extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<ErrorMessage> handleUserException(UserNotFoundException e)
    {

        return ResponseEntity.notFound().build();//fixme customize the error message
    }
}
