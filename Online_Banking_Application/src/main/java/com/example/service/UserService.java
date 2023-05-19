package com.example.service;

import java.util.List;

import com.example.model.Role;
import com.example.model.User;

public interface UserService {

	public User createUser(User user);
	public List<User> getAllUsers();
	public User getUserId(String username);
	public void deleteRoleById(String username);
}
