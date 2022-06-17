package ru.petrov.fullRestAPI.service.interfaces;

public interface ServiceCrud<T> {
    void create(T book) throws Exception;
    void delete(long id) throws Exception;
    void update(long id, T book) throws Exception;
    Object returnAll () throws Exception;
    T read(long id) throws Exception;
}
