package ru.petrov.fullRestAPI.service;

import org.springframework.stereotype.Service;
import ru.petrov.fullRestAPI.model.Book;
import ru.petrov.fullRestAPI.repository.RepositoryArrayListForBook;
import ru.petrov.fullRestAPI.service.error.ExceptionNoElement;
import ru.petrov.fullRestAPI.service.error.ExceptionNoElements;
import ru.petrov.fullRestAPI.service.error.ExceptionOverflowArrayList;
import ru.petrov.fullRestAPI.service.error.ExceptionNoHaveName;
import ru.petrov.fullRestAPI.service.interfaces.ServiceCrud;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ServiceBookCrudArrayList implements ServiceCrud<Book> {

    final RepositoryArrayListForBook repository;
    public ServiceBookCrudArrayList(RepositoryArrayListForBook repository) {
        this.repository = repository;
    }
    private static final AtomicInteger autoId = new AtomicInteger(-1);
    private Set<Integer> setId = new HashSet<>();

    @Override
    public void create(Book book) throws ExceptionOverflowArrayList, ExceptionNoHaveName{
        validInputdata(book);

        int id = autoId.incrementAndGet();

        if(id == Integer.MIN_VALUE){
            throw new ExceptionOverflowArrayList();
        }

        setId.add(id);

        Book newBook = new Book(id, book);
        repository.create(newBook);
    }

    @Override
    public void delete(long id) throws ExceptionNoElement{
        if (!setId.contains((int)id)){
            throw new ExceptionNoElement();
        }
        setId.remove((int)id);
        repository.delete(id);
    }

    @Override
    public void update(long id, Book book) throws ExceptionNoElement, ExceptionNoHaveName{
        validInputdata(book);
        if (!setId.contains((int)id)){
            throw new ExceptionNoElement();
        }

        repository.update(id, book);
    }

    @Override
    public List<Book> returnAll() throws ExceptionNoElements{
        List<Book> list = repository.returnAll();

        if (list.isEmpty()){
            throw new ExceptionNoElements();
        }

        return list;
    }

    @Override
    public Book read(long id) throws ExceptionNoElement{
        if (!setId.contains((int)id)){
            throw new ExceptionNoElement();
        }

        return repository.read(id);
    }

    private void validInputdata(Book book) throws ExceptionNoHaveName {
        if(book.getTitle() == null){
            throw new ExceptionNoHaveName();
        }
    }
}


