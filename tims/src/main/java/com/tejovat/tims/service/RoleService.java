package com.tejovat.tims.service;

import java.util.Optional;

import com.tejovat.tims.model.Role;

public interface RoleService {
	
	public Iterable<Role> getRoleList();

	public Role saveRole(Role role);

	public Role updateRole(Role role);

	public void deleteRole(Integer role);

	public Optional<Role> getRole(Integer roleId);
	
	public Role getRoleByName(String name);
}
