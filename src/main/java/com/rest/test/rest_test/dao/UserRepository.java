package com.rest.test.rest_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.test.rest_test.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
