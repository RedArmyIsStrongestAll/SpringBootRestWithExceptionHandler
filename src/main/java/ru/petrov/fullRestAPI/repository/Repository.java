package ru.petrov.fullRestAPI.repository;

import ru.petrov.fullRestAPI.model.Book;
import java.util.List;

public interface Repository {
    void saveBook(long id, Book obj);
    boolean deleteBook(long id);
    boolean changeBook(long id, Object param);
    List<Book> returnAll ();
    Book returnOne (long id);
}
