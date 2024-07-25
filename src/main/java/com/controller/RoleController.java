package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RoleEntity;
import com.repository.RoleRepository;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleRepository roleRepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody RoleEntity role ){
		
		roleRepo.save(role);
		
		return ResponseEntity.ok(role);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		
		List<RoleEntity> role = roleRepo.findAll();
		
		return ResponseEntity.ok(role);
	}
	
	@GetMapping("/get/{roleId}")
	public ResponseEntity<?> getByID(@PathVariable("roleId") Integer roleId){
		
		if(roleRepo.findById(roleId).isPresent()) {
			Optional<RoleEntity> role = roleRepo.findById(roleId);
			return ResponseEntity.ok(role);
		}
		else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	
}
