package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.domains.UserDTO;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;

@RestController
public class UserController {
    @Autowired UserService userService;
    @PostMapping("/users")
    public Map<?, ?> join(@RequestBody UserDTO user){
        System.out.println("===JOIN===");        
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
    @PostMapping("/users/login")
    public Map<?, ?> login(@RequestBody UserDTO user){
        System.out.println("===LOGIN===");        
        var map = new HashMap<>();
        System.out.println("ID: " + user.getUserid());
        System.out.println("PW: " + user.getPassword());
        UserDTO result = userService.login(user);
        if(result != null){
            map.put("message", "SUCCESS");
            map.put("loginUser", result);
        }else{
            map.put("message", "FAILURE");
            map.put("loginUser", null);
        }
        return map;
    }
    @GetMapping("/users/{userid}")
    public Map<?, ?> mypage(@PathVariable String userid){
        var map = new HashMap<>();
        System.out.println("마이페이지에서 넘어온 ID: " + userid);
        UserDTO user = userService.findById(userid);
        if(user != null){
            map.put("message", "SUCCESS");
            map.put("loginUser", user);
        }else{
            map.put("message", "FAILURE");
            map.put("loginUser", null);
        }
        map.put("message", "SUCCESS");
        return map;
    }
    @DeleteMapping
    public Map<?, ?> delete(@RequestBody UserDTO user){
        var map = new HashMap<>();
        int result = userService.delete(user);
        if(result == 1){
            map.put("message", "SUCCESS");
        }else{
            map.put("message", "FAILURE");
        }
        return map;
    }
    @PutMapping
    public Map<?, ?> update(@RequestBody UserDTO user){
        var map = new HashMap<>();
        int result = userService.update(user);
        if(result == 1){
            map.put("message", "SUCCESS");
        }else{
            map.put("message", "FAILURE");
        }
        return map;
    }
}