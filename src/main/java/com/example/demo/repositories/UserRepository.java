package com.example.demo.repositories;

import com.example.demo.domains.UserDTO;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
public int insert(UserDTO user);
public UserDTO login(UserDTO user);
public int delete(UserDTO user);
public int update(UserDTO user);
public UserDTO selectById(String userid);
}
