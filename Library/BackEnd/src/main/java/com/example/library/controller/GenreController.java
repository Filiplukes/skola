package com.example.library.controller;

import com.example.library.model.BookModel;
import com.example.library.model.Genre;
import com.example.library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;


    @GetMapping("/getGenre")
    public Genre getGenre(@RequestParam(name="id", defaultValue = "1")Long id){
        return genreService.getGenre(id);
    }

    @GetMapping("/getAllGenre")
    public List<Genre> getAllBook(){
        return genreService.getAllGenre();
    }

    @PostMapping("/setGenre")
    public void cloneDevice(@RequestBody Genre request) {
        genreService.createGenre(request);
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
