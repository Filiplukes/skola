package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookname;
    private String author;
    private Date dateRent;
    private Long genre_id;
    private Long user_id;

    public BookModel() {
    }

    public BookModel( String bookname, String author) {
        this.bookname = bookname;
        this.author = author;
        this.genre_id = genre_id;
    }

    public BookModel( String bookname, String author, Long genre_id) {
        this.bookname = bookname;
        this.author = author;
        this.genre_id = genre_id;
    }


    public BookModel(Long id, String bookname, String author, Long genre_id) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.genre_id = genre_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return bookname;
    }

    public void setName(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public Date getDateRent() {
        return dateRent;
    }

    public void setDateRent(Date dateRent) {
        this.dateRent = dateRent;
    }
}