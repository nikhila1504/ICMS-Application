package com.icms.party.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.Role;
import com.icms.party.repository.RoleRepository;

@Service(value = "roleService")
public class RoleServiceImpl {
	
	@Autowired
	private RoleRepository roleRepo;

	public Role findByName(String name) {
		Role role = roleRepo.findRoleByName(name);
		return role;
	}
}
