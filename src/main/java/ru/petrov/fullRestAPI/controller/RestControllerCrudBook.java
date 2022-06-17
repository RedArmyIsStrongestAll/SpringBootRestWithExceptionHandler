package ru.petrov.fullRestAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.petrov.fullRestAPI.controller.interfaces.ControllerCrud;
import ru.petrov.fullRestAPI.model.Book;
import ru.petrov.fullRestAPI.service.ServiceBookCrudArrayList;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestControllerCrudBook implements ControllerCrud<Book> {

    private final ServiceBookCrudArrayList service;
    public RestControllerCrudBook(ServiceBookCrudArrayList rep) {
        this.service = rep;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity requestGETall() throws Exception {
        ResponseEntity<List<Book>> result = new ResponseEntity<>(service.returnAll(), HttpStatus.OK);
        return result;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity requestGETone(@PathVariable(name = "id") long id) throws Exception {
        ResponseEntity<Book> result = new ResponseEntity<>(service.read(id), HttpStatus.OK);
        return result;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity requestPOST(@RequestBody Book obj) throws Exception {
        service.create(obj);
        ResponseEntity<String> result = new ResponseEntity<>("созадно", HttpStatus.OK);
        return result;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity requestPUT(@PathVariable(name = "id") long id, @RequestBody Book book) throws Exception {
        service.update(id, book);
        ResponseEntity<String> result = new ResponseEntity<>("обновлено", HttpStatus.OK);
        return result;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity requestDELETE(@PathVariable(name = "id") long id) throws Exception{
        service.delete(id);
        ResponseEntity<String> result = new ResponseEntity<>("удалено", HttpStatus.OK);
        return result;
    }
}
