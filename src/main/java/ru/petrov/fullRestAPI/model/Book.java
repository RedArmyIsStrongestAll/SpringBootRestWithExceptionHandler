package ru.petrov.fullRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@AllArgsConstructor
@Data
public class Book {
    private final long id;
    private String title;
    private String author;
    private Date datePublish;

    public Book (long id, Book inputBook){
        this.id = id;
        this.title = inputBook.getTitle();
        this.author = inputBook.getAuthor();
        this.datePublish = inputBook.getDatePublish();
    }
}
