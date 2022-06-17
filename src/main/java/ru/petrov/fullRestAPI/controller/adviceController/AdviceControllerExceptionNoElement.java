package ru.petrov.fullRestAPI.controller.adviceController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.petrov.fullRestAPI.service.error.ExceptionNoElement;

@RestControllerAdvice
public class AdviceControllerExceptionNoElement {

    @ExceptionHandler(ExceptionNoElement.class)
    public ResponseEntity<String> noElement(){
        return new ResponseEntity<>("элемента не найдено", HttpStatus.BAD_REQUEST);
    }

}
