package com.example.library.DTO;

import com.example.library.model.BookModel;
import com.example.library.model.ConectGenreBook;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BookDTO {
    private Long id;
    private String bookname;
    private String author;
    private Date dateRent;
    private Long userId;

    private List <ConectGenreBook> genres;

    public BookDTO() {
    }

    public BookDTO(Object data) {
        Map<String, Object> dataMap = (Map<String, Object>) data;
        this.bookname = (String) dataMap.get("bookname");
        this.author = (String) dataMap.get("author");
        this.genres = new ArrayList<>();
        List<Map<String, Object>> genresData = (List<Map<String, Object>>) dataMap.get("genres");

        genresData.forEach((gen) ->
                this.genres.add(new ConectGenreBook((Long) ((Integer) gen.get("idgenre")).longValue())));

    }

    public BookDTO( String bookname, String author) {
        this.bookname = bookname;
        this.author = author;
    }


    public BookDTO( String bookname, String author,List <ConectGenreBook> genre) {
        this.bookname = bookname;
        this.author = author;
        this.genres = genre ;
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ConectGenreBook> getlistGenre() {
        return genres;
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

    public BookModel getBookModel(){


        return new BookModel(this.bookname,this.author);
    }

    public void setDateRent(Date dateRent) {
        this.dateRent = dateRent;
    }
}
