package com.example.library.DTO;

public class BookWithGenresDTO {

    private Long id;
    private String author;
    private Long genreId;
    private Long userId;
    private String bookname;
    private String[] genresBook;


    public BookWithGenresDTO(String s, String author, String bookname, String[] genresBook, String s1) {}
    public BookWithGenresDTO(Long id, String author, String bookname, String[] genresBook, Long userId) {
        this.bookname = bookname;
        this.author = author;
        this.genresBook = genresBook;
        this.id = id;
        this.userId=userId;
    }

    public BookWithGenresDTO(Long id, String author, String name, String[] genresBook) {
        this.bookname = name;
        this.author = author;
        this.genresBook = genresBook;
        this.id = id;
    }

    public void setGenresBook(String[] genresBook) {
        this.genresBook = genresBook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String[] getGenresBook() {
        return genresBook;
    }



}