package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    
	@Query("select r from Role r ")
	public List<Role> getAllRoles();
	
	@Query
	("select r from Role r where r.roleId =?1")
	public Role getRoleById(String roleId);
}
