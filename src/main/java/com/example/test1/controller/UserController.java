package com.example.test1.controller;

import com.example.test1.model.User;
import com.example.test1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void addUser(@Validated @NonNull @RequestBody User user) {
        try {
            userService.addUser(user);
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping
    public List<User> getAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Произошла ошибка");
            return  null;
        }
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userService.getUserById(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody User user) {
        userService.updatePerson(id, user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
    }
}
