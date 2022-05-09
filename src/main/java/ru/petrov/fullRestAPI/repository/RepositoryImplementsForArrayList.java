package ru.petrov.fullRestAPI.repository;

import ru.petrov.fullRestAPI.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositoryImplementsForArrayList implements Repository {

    private static final AtomicInteger autoId = new AtomicInteger(0);

    private final List<Book> library = new ArrayList<Book>();

    @Override
    public void saveBook(Book inputBook) {
        long id = autoId.incrementAndGet();
        Book newBook = new Book(id, inputBook);
        library.add(newBook);
    }

    @Override
    public void deleteBook(long id) {
        library.remove(id);
    }

    @Override
    public void editBook(long id, Book inputBook) {
        //СОЗДАТЬ SERVICE КОТОРЫЙ БУДЕТ ИЗМЕНЯТЬ ПЕРЕДАННОЕ ПОЛЕ,
        //А ОРСТАЛЬНЫЕ ОСТАВЛЯТЬ ПРЕЖНИМИ И ПЕРЕДОВАТЬ В ЭТОТ МЕТОД
        Book editBook = new Book(id, inputBook);
        Book BookForSearchIndexInList = (Book) library.stream().filter(book -> book.getId() == id);
        //ДОБАВИТЬ ВТОРУЮ КОЛЛЕКЦИЮ LIBRARY2 И СЕРВИС, КОТОРЫЙ БУДЕТ СМОТРЕТЬ В КАКОЙ КОЛЛЕКЦИИ ЛЕЖИТ ОБЪКТ
        //И ПУСТЬ БУДЕТ СЕРВИС, КОТОРЫЙ СОЗДАЁТ НОВЫЕ КОЛЛЕКЦИИ, ЕСЛИ МЕСТО В СТАРОЙ КОНЧАЕТСЯ
        //МЕСТО ЗАКОНЧЕНО - ЕСЛИ КОЛИЧЕСТВО ЭЛЕМЕНТОВ ПРИВЫСИЛО МАКС ЗАНАЧЕНИЕ INT
        int indexInList = (int) BookForSearchIndexInList.getId();
        library.set(indexInList, editBook);
    }

    @Override
    public List<Book> returnAll() {
        return library;
    }

    @Override
    public Book returnOne(long id) {
        //ДОБАВИТЬ ВТОРУЮ КОЛЛЕКЦИЮ LIBRARY2 И СЕРВИС, КОТОРЫЙ БУДЕТ СМОТРЕТЬ В КАКОЙ КОЛЛЕКЦИИ ЛЕЖИТ ОБЪКТ
        return (Book) library.stream().filter(book -> book.getId() == id);
    }
}
