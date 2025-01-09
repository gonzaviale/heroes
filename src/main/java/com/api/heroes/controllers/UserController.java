package com.api.heroes.controllers;

import com.api.heroes.models.DTO.UserDTO;
import com.api.heroes.models.UserModel;
import com.api.heroes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserDTO> getUser() {
        ArrayList<UserModel> users = this.userService.getAllUsers();
        ArrayList<UserDTO> usersDTO = new ArrayList<>();
        for (UserModel user : users) {
            usersDTO.set(users.indexOf(user), this.userService.convertToDTO(user));
        }
        return usersDTO;
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        UserModel user = this.userService.getUserById(id);
        return this.userService.convertToDTO(user);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserModel user) {
        UserModel updatedUser = this.userService.updateUser(user);
        return this.userService.convertToDTO(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }
}
