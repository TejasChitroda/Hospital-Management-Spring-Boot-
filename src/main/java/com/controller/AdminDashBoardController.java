package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EmployeeEntity;
import com.repository.EnployeeRepository;

@RestController
@RequestMapping("/admindashboard")
public class AdminDashBoardController {
	
	@Autowired
	EnployeeRepository employeeRepo;
	
	@PostMapping("/adminlogin")
	public ResponseEntity<?> adminLogin(@RequestBody EmployeeEntity employee) {
		
		String email = employee.getEmail();
		String password = employee.getPassword();
		String expectedRole = "Admin";
		
		
		EmployeeEntity emp = employeeRepo.findByEmail(email);
		
		
	
		
		if (emp == null) {
	        return ResponseEntity.badRequest().body("Employee with email " + email + " not found");
	    }

	    if (!emp.getPassword().equals(password)) {
	        return ResponseEntity.badRequest().body("Incorrect password");
	    }
	    
	    
	    String actualRole = emp.getRole().getRoleName();
	    
	    
	    if (!expectedRole.equals(actualRole)) {
	        return ResponseEntity.badRequest().body("You are not an admin");
	    }

	    
	    return ResponseEntity.ok(emp);
	}
	
	
}
