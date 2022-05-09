package ru.petrov.fullRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@AllArgsConstructor
@Data
public class Book {
    final long id;
    String title;
    String author;
    Date datePublish;

    public Book (long id, Book inputBook){
        this.id = id;
        this.title = inputBook.getTitle();
        this.author = inputBook.getAuthor();
        this.datePublish = inputBook.getDatePublish();
    }
}
