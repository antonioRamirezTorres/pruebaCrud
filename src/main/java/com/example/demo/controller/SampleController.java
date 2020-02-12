package com.example.demo.controller;

import com.example.demo.dto.SampleUserDto;
import com.example.demo.service.ISampleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SampleController {

    @Autowired
    private ISampleUserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<SampleUserDto> getUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional<SampleUserDto> getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST, produces = "application/json")
    public SampleUserDto addUser(@RequestBody SampleUserDto user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
