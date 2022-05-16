package com.example.app.hotel.services;

import com.example.app.hotel.models.User;
import com.example.app.hotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String saveUser(User user) {
        userRepository.save(user);
        return "User successfully saved";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getOneUser(int id) {
        return userRepository.findById(id);
    }

    public String updateUser(User user, int id) {
        User existingUser = userRepository.findById(id).orElse(null);
        existingUser.setUserName(user.getUserName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setMobile(user.getMobile());
        existingUser.setRole(user.getRole());
        userRepository.save(existingUser);
        return "User updated successfully";
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User successfully deleted";
    }

}
