package com.example.springbootauthorizationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/create-user")
    public User createUser(@RequestBody String username, @RequestHeader("user") String authUser) {
        if (!userService.hasPermission(authUser, "access.create"))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        return userService.createUser(username);
    }

    @PutMapping("add-permission/{username}")
    public void addPermission(@PathVariable("username") String username, @RequestBody String permission, @RequestHeader("user") String authUser) {
        if (!userService.hasPermission(authUser, "access.addpermission"))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        if (!userService.addPermission(username, permission))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
