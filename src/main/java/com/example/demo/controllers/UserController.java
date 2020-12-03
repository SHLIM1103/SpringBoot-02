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
    @Autowired UserService UserService;
    @PostMapping("/users")
    public Map<String, String> join(@RequestBody UserDTO user){
        System.out.println("===JOIN===");        
        Map<String, String> map = new HashMap<>();
        System.out.println("ID: " + user.getUserid());
        System.out.println("PW: " + user.getPassword());
        System.out.println("NAME: " + user.getName());
        int result = UserService.join(user);
        if(result == 1){
            map.put("name", user.getName());
        }else{
            map.put("name", "FAILURE");
        }
        return map;
    }
}
