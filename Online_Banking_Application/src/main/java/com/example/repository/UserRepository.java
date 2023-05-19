package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
   
	@Query("select u from User u ")
	public List<User> getAllUsers();
	
	@Query
	("select u from User u where u.username =?1")
	public User getUserId(String username);
}