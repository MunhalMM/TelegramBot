package org.telbot.telran.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listAllUser() {
        return userService.listAllUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable(name = "id") int id) {
        return userService.getUser(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") int id) {
        userService.deleteUser(id);
    }

}
