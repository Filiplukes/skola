package com.example.library.service;

import com.example.library.DTO.BookDTO;
import com.example.library.model.BookModel;
import com.example.library.model.ConectGenreBook;
import com.example.library.repository.BookRepository;
import com.example.library.repository.ConectGenreRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class BookServices {
    @Resource
    BookRepository bookRepository;
    @Resource
    private final ConectGenreRepository conectGenreRepository;

    public BookServices(ConectGenreRepository conectGenreRepository) {
        this.conectGenreRepository = conectGenreRepository;
    }

    public List<BookModel> getAllBook() {
        return bookRepository.findAll();
    }
    public BookModel getBook(Long id) {
        return bookRepository.getReferenceById(id);
    }

    public void createBook(BookDTO book){
        List<ConectGenreBook> genres = book.getlistGenre();
        long idBook = bookRepository.save(book.getBookModel()).getId();

        for (ConectGenreBook genre : genres) {
           genre.setIdBook(idBook);
           conectGenreRepository.save(genre);
        }
    }

   public List<BookModel> getMyBook(Long accoutnId){
       return bookRepository.findByUserId(accoutnId);
   }
    public void rentBook(BookModel book){
       BookModel updateBook = getBook(book.getId());
       updateBook.setUserId(book.getUserId());
       bookRepository.save(updateBook);
    }
}
