package com.example.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.RoleException;
import com.example.model.Role;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	 RoleRepository roleRepository;

	@Override
	public Role createRole(Role role) {

		// Perform validation checks
	    if (role.getRoleName() == null || role.getRoleName().isEmpty()) {
	        throw new IllegalArgumentException("Role name is required.");
	    }

	    // Check if the role with the same name already exists
	    if (roleRepository.existsById(role.getRoleName())) {
	        throw new RoleException("Role with name " + role.getRoleName() + " already exists.");
	    }

	    // Perform any other necessary validations or business logic
	    
	    // Save the role to the repository
	    return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		
		 return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(String roleId) {
		
		 return roleRepository.findById(roleId)
	                .orElseThrow(() -> new RoleException("Role not found with ID: " + roleId));
	}

	@Override
	public void deleteRoleById(String roleId) {
		
Role existingRole = getRoleById(roleId);
        
        // Perform any necessary validations or business logic
        
        // Delete the role from the repository
        roleRepository.delete(existingRole);
		
	}
	
	
	
}
