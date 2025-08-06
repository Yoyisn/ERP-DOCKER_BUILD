package com.demo.erp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.demo.erp.services.UserService;

import lombok.RequiredArgsConstructor;
import com.demo.erp.dto.UserDto;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("apiUsers")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    };

    @PostMapping("/createUser")
    public UserDto createUser(@RequestBody UserDto request) {
        return userService.createUser(request);
    };

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

};