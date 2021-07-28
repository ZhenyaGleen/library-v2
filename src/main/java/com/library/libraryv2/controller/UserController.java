package com.library.libraryv2.controller;

import com.library.libraryv2.model.User;
import com.library.libraryv2.repository.UserRepository;
import com.library.libraryv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> listUsers(){
        return userService.searchUsers();
    }
}
