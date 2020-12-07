package com.example.demo.services;

import com.example.demo.domains.UserDTO;

public interface UserService {
	public int join(UserDTO user);
	public UserDTO login(UserDTO user);
	public UserDTO findById(String userid);
	public int delete(UserDTO user);
	public int update(UserDTO user);
}
