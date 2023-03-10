package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ConectGenreBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idBook;
    private Long idGenre;

    public ConectGenreBook() {
    }

    public ConectGenreBook(Long idGenre) {
        this.idGenre = idGenre;
    }
    public ConectGenreBook(Long id, Long idBook, Long idGenre) {
        this.id = id;
        this.idBook = idBook;
        this.idGenre = idGenre;
    }

    public ConectGenreBook(Long idBook, Long idGenre) {
        this.idBook = idBook;
        this.idGenre = idGenre;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Long getIdBook() {
        return idBook;
    }

    public Long getIdGenre() {
        return idGenre;
    }

    public Long getId() {
        return id;
    }


}