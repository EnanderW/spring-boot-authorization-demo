package com.example.springbootauthorizationdemo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    private String name;

    private List<String> permissions;

    public User(String name) {
        this.name = name;
        this.permissions = new ArrayList<>();
    }
}
