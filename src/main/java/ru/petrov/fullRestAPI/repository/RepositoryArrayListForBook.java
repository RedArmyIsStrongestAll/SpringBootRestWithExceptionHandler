package ru.petrov.fullRestAPI.repository;

import ru.petrov.fullRestAPI.model.Book;
import ru.petrov.fullRestAPI.repository.interfaces.RepositoryCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Repository
public class RepositoryArrayListForBook implements RepositoryCrud<Book> {

    private List<Book> library = new ArrayList<>();

    @Override
    public void create(Book book) {
        library.add(book);
    }

    @Override
    public void delete(long id) {
        library.remove(library.stream().filter(book -> book.getId() == id).findFirst().get());
    }

    @Override
    public void update(long id, Book inputBook) {
        Book editBook = new Book(id, inputBook);
        library.forEach(book -> {
            if (book.getId() == id){
                int idSearchBook = library.indexOf(book);
                library.set(idSearchBook, editBook);
            };
        });
    }

    @Override
    public List<Book> returnAll() {
        return library;
    }

    @Override
    public Book read(long id) {
        return library.stream().filter(book -> book.getId() == id).findFirst().get();
    }
}
