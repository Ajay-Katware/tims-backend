package com.tejovat.tims.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejovat.tims.model.Role;
import com.tejovat.tims.repository.RoleRepository;
import com.tejovat.tims.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository repo;

	@Override
	public Iterable<Role> getRoleList() {
		return repo.findAll();
	}

	@Override
	public Role saveRole(Role role) {
		return repo.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		return repo.save(role);
	}

	@Override
	public void deleteRole(Integer roleId) {
		Role role = getRole(roleId);
		if(role!=null) {
			repo.delete(role);
		}
	}

	@Override
	public Role getRole(Integer roleId) {
		return repo.findOne(roleId);
	}

	@Override
	public Role getRoleByName(String name) {
		return null;
	}

}
