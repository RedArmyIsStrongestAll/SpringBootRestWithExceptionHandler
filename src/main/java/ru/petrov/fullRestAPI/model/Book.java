package ru.petrov.fullRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@Data
public class Book {
    private final long id;
    private String title;
    private String author;

    public Book (){
        this.id = 0;
    }

    public Book (long id, Book inputBook) {
        this.id = id;
        this.title = inputBook.getTitle();
        this.author = inputBook.getAuthor();
    }
}
