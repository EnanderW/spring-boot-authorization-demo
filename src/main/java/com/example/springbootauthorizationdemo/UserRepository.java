package com.example.springbootauthorizationdemo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private Map<String, User> users = new HashMap<>();

    public UserRepository() {
        User admin = new User("admin");
        admin.getPermissions().add("access.addpermission");
        users.put("admin", admin);
    }

    public User get(String username) {
        return users.get(username.toLowerCase());
    }

    public void save(User user) {
        users.put(user.getName().toLowerCase(), user);
    }

}
