package com.rest.test.rest_test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.test.rest_test.entities.User;
import com.rest.test.rest_test.service.UserService;

// @Controller
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String hadleString() {
        return "This string for test only...";
    }

    @PostMapping("/user")
    public ResponseEntity<User> addBooks(@RequestBody User user) {
        try {
            this.userService.addUser(user);
            System.out.println("addBooks in controller " + user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getBooks() {
        List<User> books = userService.getUsers();
        try {
            if (books.size() <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            // handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.of(Optional.of(books));
    }

}
