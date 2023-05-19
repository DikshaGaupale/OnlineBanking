package com.example.service;

import java.util.List;

import com.example.model.Role;

public interface RoleService {

	public Role createRole(Role role);
	public List<Role> getAllRoles();
	public Role getRoleById(String roleId);
	public void deleteRoleById(String roleId);
}
