package com.example.library.service;

import com.example.library.DTO.BookDTO;
import com.example.library.DTO.BookWithGenresDTO;
import com.example.library.model.BookModel;
import com.example.library.model.ConectGenreBook;
import com.example.library.repository.BookRepository;
import com.example.library.repository.ConectGenreRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<BookWithGenresDTO> getAllBookWithGenre() {

        List<BookWithGenresDTO> result = new ArrayList<>();
        for (Object[] objects : bookRepository.findAllBooksWithGenres()) {
            BookModel b = (BookModel) objects[0];

            String [] genres = (String[]) objects[1];

            if (genres != null && genres.length == 1 && genres[0] == null) {
                genres = new String[0];
            }

            result.add(new BookWithGenresDTO(b.getId(), b.getAuthor(), b.getName(), genres,b.getUserId()));
        }
        return result;

    }


    public List<BookWithGenresDTO> findByUserIdWithGenres(Long id) {

        List<BookWithGenresDTO> result = new ArrayList<>();
        for (Object[] objects : bookRepository.findByUserIdWithGenres(id)) {
            BookModel b = (BookModel) objects[0];

            String [] genres = (String[]) objects[1];

            if (genres != null && genres.length == 1 && genres[0] == null) {
                genres = new String[0];
            }

            result.add(new BookWithGenresDTO(b.getId(), b.getAuthor(), b.getName(), genres,b.getUserId()));
        }
        return result;

    }

    public BookWithGenresDTO findRandomBookByAuthor(String author){

        Object source = bookRepository.findRandomBookByAuthor(author);
        if (source != null) {
            BookModel b = (BookModel) ((Object[]) source)[0];
            String [] genres = (String[]) ((Object[]) source)[1];

            if (genres != null && genres.length == 1 && genres[0] == null) {
                genres = new String[0];
            }

            return new BookWithGenresDTO(b.getId(), b.getAuthor(), b.getName(), genres,b.getUserId());
        } else {
            return new BookWithGenresDTO("", "", "", new String[]{}, "");
        }

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
