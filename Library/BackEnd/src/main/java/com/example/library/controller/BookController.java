package com.example.library.controller;

import com.example.library.DTO.BookDTO;
import com.example.library.DTO.BookWithGenresDTO;
import com.example.library.model.Account;
import com.example.library.model.BookModel;
import com.example.library.model.Genre;
import com.example.library.service.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private BookServices bookServices;


    @GetMapping("/getAllBook")
    public List<BookModel> getAllBook(){
        return bookServices.getAllBook();
    }

    @GetMapping("/getAllBookWithGenre")
    public List<BookWithGenresDTO> getAllBookWithGenre(){
        return bookServices.getAllBookWithGenre();
    }

    @PostMapping("/getMyBook")
    public List<BookModel> getMyBook(@RequestBody Account request){
        return bookServices.getMyBook(request.getId());
    }

    @PostMapping("/getMyBookWithGenre")
    public List<BookWithGenresDTO> getMyBookWithGenre(@RequestBody Account request){
        return bookServices.findByUserIdWithGenres(request.getId());
    }

    @GetMapping("/findRandomBookByAuthor")
    public BookWithGenresDTO findRandomBookByAuthor(@RequestParam(name="autor", defaultValue = "")String autor){
        return bookServices.findRandomBookByAuthor(autor);
    }


    @GetMapping("/getBook")
    public BookModel getBook(@RequestParam(name="id", defaultValue = "1")Long id){
        return bookServices.getBook(id);
    }

    @PostMapping("/setBook")
    public void createBook(@RequestBody Object request) {
        BookDTO book = new BookDTO(request);
        bookServices.createBook(book);

    }

    @PostMapping("/rentBook")
    public void rentBook(@RequestBody BookModel request) {
        bookServices.rentBook(request);
    }

//
//        @PostMapping("/create")
//        public UserRestApp createUser(@RequestParam(name="name")String name,@RequestParam(name="surname")String surname,@RequestParam(name="age")int age){
//            UserRestApp createUser = new UserRestApp(name,surname,age);
//
//            return createUser;
//
//        }
//
//        @PutMapping("/update")
//        public UserRestApp updateUser(@RequestParam(name="id")int id,@RequestParam(name="name")String name,
//                                      @RequestParam(name="surname")String surname,@RequestParam(name="age")int age){
//            ListUsersTEst testUser = new ListUsersTEst();
//            testUser.update(id,name,surname,age);
//
//            return testUser.getUsersList(id);
//        }


}
