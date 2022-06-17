package ru.petrov.fullRestAPI.repository.interfaces;

public interface RepositoryCrud<T> {
    void create(T inputBook);
    void delete(long id);
    void update(long id, T inputBook);
    Object returnAll ();
    T read(long id);
}
