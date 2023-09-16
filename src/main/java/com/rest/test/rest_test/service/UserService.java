package com.rest.test.rest_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.test.rest_test.dao.UserRepository;
import com.rest.test.rest_test.entities.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        this.userRepository.save(user);
        System.out.println("add user in service " + user);
        return user;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
