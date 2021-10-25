package com.example.springbootauthorizationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(String username) {
        User existing = userRepository.get(username);
        if (existing != null)
            return null;

        User user = new User(username);
        userRepository.save(user);
        return user;
    }

    public boolean addPermission(String username, String permission) {
        User user = userRepository.get(username);
        if (user == null)
            return false;

        user.getPermissions().add(permission);
        return true;
    }

    public boolean hasPermission(String username, String permission) {
        User user = userRepository.get(username);
        if (user == null)
            return false;

        return user.getPermissions().contains(permission);
    }
}
