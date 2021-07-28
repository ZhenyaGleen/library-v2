package com.library.libraryv2.controller;

import com.library.libraryv2.model.User;
import com.library.libraryv2.repository.UserRepository;
import com.library.libraryv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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

    @GetMapping("/users/{id}")
    public User listUser(@PathVariable Long id){
        return userService.searchUser(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){

        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        userService.searchUser(id);

        user.setEmail(user.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());

        userService.createUser(user);

        return user;
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
