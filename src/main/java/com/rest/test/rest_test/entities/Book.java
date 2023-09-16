package com.rest.test.rest_test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String auther;

    @OneToOne(mappedBy = "book")
    @JsonBackReference
    private User user;

    public Book() {
    }

    public Book(int id, String name, String auther) {
        this.id = id;
        this.name = name;
        this.auther = auther;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", auther=" + auther + "]";
    }
}
