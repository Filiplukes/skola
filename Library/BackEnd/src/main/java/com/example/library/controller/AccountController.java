package com.example.library.controller;

import com.example.library.model.Account;
import com.example.library.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping("/getAccount")
    public Optional<Account> getAccount(@RequestBody Account request){
        return accountService.getAccount(request.getId());
    }

    @PostMapping("/setAccount")
    public Long createAccount(@RequestBody Account request) {

        Long id =  accountService.createAccount(request);

        return id;
    }

    @PostMapping("/login")
    public Long checkoutLogin(@RequestBody Account request) {

        Long id =  accountService.loginAccount(request);

        return id;
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
