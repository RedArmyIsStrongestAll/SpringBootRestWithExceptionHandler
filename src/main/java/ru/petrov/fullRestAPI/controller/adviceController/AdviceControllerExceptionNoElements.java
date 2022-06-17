package ru.petrov.fullRestAPI.controller.adviceController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.petrov.fullRestAPI.service.error.ExceptionNoElements;

@RestControllerAdvice
public class AdviceControllerExceptionNoElements {

    @ExceptionHandler(ExceptionNoElements.class)
    public ResponseEntity<String> noElements(){
        return new ResponseEntity<>("база данных не содержит элементов", HttpStatus.NOT_FOUND);
    }

}