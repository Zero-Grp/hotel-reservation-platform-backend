package com.example.app.hotel.controllers;

import com.example.app.hotel.models.User;
import com.example.app.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/")
    public String save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(path = "/")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> get(@PathVariable int id) {
        return userService.getOneUser(id);
    }

    @PutMapping(path = "/{id}")
    public String update(@RequestBody User user, @PathVariable int id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}
