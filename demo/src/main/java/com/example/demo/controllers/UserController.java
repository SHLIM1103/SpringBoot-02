package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.domains.UserDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/users")
    public Map<String, String> join(@RequestBody UserDTO user){
        System.out.println("=== Join ===");
        Map<String, String> map = new HashMap<>();
        System.out.println("ID: " + user.getUserid());
        System.out.println("PW: " + user.getPassword());
        System.out.println("NAME: " + user.getName());
        map.put("name", user.getName());
        return map;
    }
}
