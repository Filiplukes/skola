package com.example.library.service;

import com.example.library.model.BookModel;
import com.example.library.repository.BookRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class BookServices {
    @Resource
    BookRepository bookRepository;

    public List<BookModel> getAllBook() {
        return bookRepository.findAll();
    }
    public BookModel getBook(Long id) {
        return bookRepository.getReferenceById(id);
    }

    public void createBook(BookModel book){
        bookRepository.save(book);
    }

//    public List<BookModel> getMyBook(Long bookModel){
//        return bookRepository.findByUserId(bookModel);
//    }
    public void rentBook(BookModel book){
       BookModel updateBook = getBook(book.getId());
       updateBook.setUser_id(book.getUser_id());
       bookRepository.save(updateBook);
    }
}
