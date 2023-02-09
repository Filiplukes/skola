package com.example.library.controller;

import com.example.library.model.BookModel;
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

//    @PostMapping("/getMyBook")
//    public List<BookModel> getMyBook(@RequestBody BookModel request){
//        return bookServices.getMyBook(request.getUser_id());
//    }

    @GetMapping("/getBook")
    public BookModel getBook(@RequestParam(name="id", defaultValue = "1")Long id){
        return bookServices.getBook(id);
    }

    @PostMapping("/setBook")
    public void createBook(@RequestBody BookModel request) {
        bookServices.createBook(request);
    }

//    @PostMapping("/rentBook")
//    public void rentBook(@RequestBody BookModel request) {
//        bookServices.rentBook(request);
//    }

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
