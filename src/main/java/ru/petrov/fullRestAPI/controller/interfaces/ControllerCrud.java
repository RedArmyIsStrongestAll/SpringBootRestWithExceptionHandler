package ru.petrov.fullRestAPI.controller.interfaces;

import org.springframework.http.ResponseEntity;

public interface ControllerCrud<T> {
    ResponseEntity requestGETall() throws Exception;
    ResponseEntity requestGETone(long id) throws Exception;
    ResponseEntity requestPOST(T book) throws Exception;
    ResponseEntity requestPUT(long id, T book) throws Exception;
    ResponseEntity requestDELETE(long id) throws Exception;
}
