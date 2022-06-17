package ru.petrov.fullRestAPI.controller.adviceController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.petrov.fullRestAPI.service.error.ExceptionNoHaveName;

@RestControllerAdvice
public class AdviceControllerExceptionNoHaveName {

    @ExceptionHandler(ExceptionNoHaveName.class)
    public ResponseEntity<String> noName(){
        return new ResponseEntity<>("отсутствует имя", HttpStatus.NOT_ACCEPTABLE);
    }

}
