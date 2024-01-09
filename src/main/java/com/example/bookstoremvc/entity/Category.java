package com.example.bookstoremvc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String CategoryName;
    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        book.setCategory(this);
        books.add(book);
    }
}
