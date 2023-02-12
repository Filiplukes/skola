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
    private Long genreId;
    private Long userId;

    public BookModel() {
    }

    public BookModel( String bookname, String author) {
        this.bookname = bookname;
        this.author = author;
    }

    public BookModel( String bookname, String author, Long genreId) {
        this.bookname = bookname;
        this.author = author;
        this.genreId = genreId;
    }


    public BookModel(Long id, String bookname, String author, Long genreId) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.genreId = genreId;
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

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public Long getUserId() {
        return userId;
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