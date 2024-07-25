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

import com.entity.EmployeeEntity;
import com.repository.EnployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EnployeeRepository employeeRepo;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody EmployeeEntity employee) {
		
		employeeRepo.save(employee);
		
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		
		List<EmployeeEntity> employee = employeeRepo.findAll();
		
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/get/{employeeId}")
	public ResponseEntity<?> getById(@PathVariable("employeeId") Integer employeeId) {
		
		if (employeeRepo.findById(employeeId).isPresent()) {
			
			Optional<EmployeeEntity> employee = employeeRepo.findById(employeeId);
			
			return ResponseEntity.ok(employee);
		}
		
		else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<?> deleteById(@PathVariable("employeeId") Integer employeeId) {
		
		Optional<EmployeeEntity> employee = employeeRepo.findById(employeeId);

		if (employee != null) {
			employeeRepo.deleteById(employeeId);
			
			return ResponseEntity.ok(employee);
		}
		else {
			return ResponseEntity.noContent().build();

		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeEntity employee) {
		
		EmployeeEntity oldEmployee = employeeRepo.findById(employee.getEmployeeId()).get();
		
		
		if (oldEmployee != null) {
			
			oldEmployee.setAadharCardPath(employee.getAadharCardPath());
			oldEmployee.setActiveInd(employee.isActiveInd());
			oldEmployee.setContactNum(employee.getContactNum());
			oldEmployee.setDateOfJoining(employee.getDateOfJoining());
			oldEmployee.setEmail(employee.getEmail());
			oldEmployee.setEmployeeTitleName(employee.getEmployeeTitleName());
			oldEmployee.setFirstName(employee.getFirstName());
			oldEmployee.setGender(employee.getGender());
			oldEmployee.setLastName(employee.getLastName());
			oldEmployee.setPanCardPath(employee.getPanCardPath());
			oldEmployee.setPassword(employee.getPassword());
			oldEmployee.setQualification(employee.getQualification());
			oldEmployee.setQualificationDocPath(employee.getQualificationDocPath());
			oldEmployee.setRole(employee.getRole());
			
			employeeRepo.save(oldEmployee);
			
			return ResponseEntity.ok(oldEmployee);
			
		}
		
		employeeRepo.save(oldEmployee);
		
		return ResponseEntity.ok(oldEmployee);
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> employeeLogin(@RequestBody EmployeeEntity employee) {
		
		
		String emp = employee.getEmail();
		String pass = employee.getPassword();
		
		EmployeeEntity empl = employeeRepo.findByEmail(emp);
		
		if (empl != null && empl.getEmail().equals(emp)) {
				
			
			return ResponseEntity.ok(empl);
			
		}
		
		
		return ResponseEntity.notFound().build();
		
	}
	
}
