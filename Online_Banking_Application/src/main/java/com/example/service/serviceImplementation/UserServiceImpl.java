package com.example.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.UserException;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public User createUser(User user) {
		
		// Perform validation checks
	    if (user.getUsername() == null || user.getUsername().isEmpty()) {
	        throw new IllegalArgumentException("Username is required.");
	    }
	    
	    if (user.getPassword() == null || user.getPassword().isEmpty()) {
	        throw new IllegalArgumentException("Password is required.");
	    }
	    
	    // Check if the user with the same username already exists
	    if (userRepository.existsById(user.getUsername())) {
	        throw new UserException("User with username " + user.getUsername() + " already exists.");
	    }
	    
	    // Perform any other necessary validations or business logic
	    
	    // Save the user to the repository
	    return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserId(String username) {
		
		return userRepository.findById(username)
	            .orElseThrow(() -> new UserException("User with username " + username + " not found."));
	}

	@Override
	public void deleteRoleById(String username) {
		// TODO Auto-generated method stub
		User user = getUserId(username);
	    userRepository.delete(user);
	}

}
