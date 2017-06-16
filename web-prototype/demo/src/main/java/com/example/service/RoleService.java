package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAllRoles(int userId){
		return roleRepository.findAllById(userId);
	}
	
	public Role getRole(int userId){
	    return roleRepository.findOne(userId);
	}
	
	public void addRole(Role role){
		roleRepository.save(role);
	}
	
	public void updateRole(Role role){
		roleRepository.save(role);
	}

	public void deleteRole(int roleId){
		roleRepository.delete(roleId);
	}
	
}
