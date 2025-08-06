package com.demo.erp.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.demo.erp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import com.demo.erp.models.User;
import com.demo.erp.dto.UserDto;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get method to retrieve all users
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    // Post method to create a new User
    public UserDto createUser(UserDto request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);
        return new UserDto(savedUser);
    }

    public String deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return "User with id " + id + " does not exist";
        } else {
            userRepository.deleteById(id);
            return "User with id " + id + " deleted successfully";
        }
    }

}