package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.domains.UserDTO;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired UserService userService;
    @PostMapping("/users")
    public Map<?, ?> join(@RequestBody UserDTO user){
        var map = new HashMap<>();
        System.out.println("ID: " + user.getUserid());
        System.out.println("PW: " + user.getPassword());
        System.out.println("NAME: " + user.getName());
        int result = userService.join(user);
        if(result == 1){
            map.put("message", "SUCCESS");
        }
        return map;
    }
}
