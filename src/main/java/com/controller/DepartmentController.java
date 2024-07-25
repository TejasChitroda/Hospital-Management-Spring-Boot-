package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.DepartmentEntity;
import com.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository departmentRepo;
	
	// ADD DEPARTMENTS;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody DepartmentEntity department) {
		
		departmentRepo.save(department);
		
		return ResponseEntity.ok(department);
	}
	
	// get all records
	//  SELECT * FROM DEPARTMENTS;
	
	@GetMapping("/all") 
	public ResponseEntity<?> getAllDepartments() {
		
		List<DepartmentEntity> department = departmentRepo.findAll();
		
		return ResponseEntity.ok(department);
	}
	
	// GET record by id
	// SELECT * FROM DEPARTMENT WHERE DEPARTMENTID = ? ;
	
	@GetMapping("/get/{departmentId}") 
	public ResponseEntity<?> getDepartmentById(@PathVariable("departmentId") Integer departmetnId) {
		
		if(departmentRepo.findById(departmetnId).isPresent()) {
			DepartmentEntity department = departmentRepo.findById(departmetnId).get();
			return ResponseEntity.ok(department);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	// delete record(department)
	
	@DeleteMapping("/delete/{departmentId}")
	public ResponseEntity<?> deleteDepartmentById(@PathVariable("departmentId") Integer departmentID) {
		
		Optional<DepartmentEntity> department = departmentRepo.findById(departmentID);
		
		if ( department != null ) {
			departmentRepo.deleteById(departmentID);
			
			return ResponseEntity.ok(department);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	// Update department record
	
	@PutMapping("/update")
	public ResponseEntity<?> updateDepartment(@RequestBody DepartmentEntity department) {
		
		DepartmentEntity oldDepartment = departmentRepo.findById(department.getDepartmentId()).get();
		
//		if ( oldDepartment.getName() != null ) {
//			oldDepartment.setName(department.getName());
//		}
//		else if (oldDepartment.getActive() != null) {
//			oldDepartment.setActive(department.getActive());
//		}
		
		
		if (oldDepartment != null) {
	        // Update all relevant fields based on the values provided in the request body
	        oldDepartment.setName(department.getName());
	        oldDepartment.setActive(department.getActive());
	        
	        departmentRepo.save(oldDepartment);
	        
	        return ResponseEntity.ok(oldDepartment);
		}
		departmentRepo.save(oldDepartment);
		
		return ResponseEntity.ok(oldDepartment);
	}
}


















