package ru.petrov.fullRestAPI.controller.adviceController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.petrov.fullRestAPI.service.error.ExceptionOverflowArrayList;

@RestControllerAdvice
public class AdviceControllerExceptionOverflowArrayList {

    @ExceptionHandler(ExceptionOverflowArrayList.class)
    public ResponseEntity<String> noSpace(){
        return new ResponseEntity<>("база данных переполнена", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

