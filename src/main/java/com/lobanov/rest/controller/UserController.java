package com.lobanov.rest.controller;

import com.lobanov.rest.model.Passport;
import com.lobanov.rest.model.User;
import com.lobanov.rest.service.PassportService;
import com.lobanov.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private  UserService userService;
    private PassportService passportService;

    public UserController(UserService userService, PassportService passportService) {
        this.userService = userService;
        this.passportService = passportService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> allUsers = userService.findAll();
        return allUsers;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        return user;
    }

    @PostMapping("/users")
    public User insertUser(@RequestBody User user) {
        User auxUser = userService.saveUser(user);
        user.setId(auxUser.getId());
        Passport passport = user.getPassport();
        passportService.savePassport(passport);

        return user;
    }

    @PutMapping("/users")
    public User editUserData( @RequestBody User user) {
        userService.saveUser(user);
        return  user;
    }
    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
