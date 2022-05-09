package ru.petrov.fullRestAPI.repository;

import ru.petrov.fullRestAPI.model.Book;
import java.util.List;

public interface Repository {
    void saveBook(Book inputBook);
    void deleteBook(long id);
    void editBook(long id, Book inputBook);
    Object returnAll ();
    Object returnOne (long id);
}
