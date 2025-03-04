package com.example.usermanagement.controller;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        userService.saveUser(user);  
        return "User created successfully";
    }

    @PutMapping("/{username}")
    public String updateUser(@PathVariable String username, @RequestBody User user) {
        userService.updateUser(username, user);
        return "User updated successfully";
    }

    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return "User deleted successfully";
    }
}
