package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>{
	
	Role findByRole(String role);
	List<Role> findAllById(int id);
	
}
