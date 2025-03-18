package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.User;
import com.example.demo.UserService;
import java.util.Optional;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        // 如果沒有找到User, 回傳404
        return user.orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
    }
}


