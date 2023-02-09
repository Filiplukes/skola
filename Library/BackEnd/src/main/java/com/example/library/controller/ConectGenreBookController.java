package com.example.library.controller;

import com.example.library.model.ConectGenreBook;
import com.example.library.model.Genre;
import com.example.library.service.ConectGenreBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/connectGenreBook")
public class ConectGenreBookController {

    @Autowired
    private ConectGenreBookService conectGenreBookService;


    @GetMapping("/getGenreBook")
    public ConectGenreBook getConectGenreBook(@RequestParam(name="id", defaultValue = "1")Long id){
        return conectGenreBookService.getConectGenre(id);
    }

    @PostMapping("/setGenreBook")
    public void createConectGenre(@RequestBody ConectGenreBook request) {
        conectGenreBookService.createConectGenre(request);
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
