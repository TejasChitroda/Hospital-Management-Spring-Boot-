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

import com.entity.ServiceTypeEntity;
import com.repository.ServiceTypeRepository;

@RestController
@RequestMapping("/serviceType")
public class ServiceTypeController {
	
	@Autowired
	ServiceTypeRepository serviceRepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ServiceTypeEntity services) {
		
		serviceRepo.save(services);
		return ResponseEntity.ok(services);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllServices() {
		List<ServiceTypeEntity> services = serviceRepo.findAll();
		
		return ResponseEntity.ok(services);
	}
	
	@GetMapping("get/{serviceTypeId}")
	public ResponseEntity<?> getServiceById(@PathVariable("serviceTypeId") Integer serviceTypeId) {
		
		Optional<ServiceTypeEntity> services = serviceRepo.findById(serviceTypeId);
		
		if (services != null) {
			return ResponseEntity.ok(services);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/delete/{serviceTypeId}")
	public ResponseEntity<?> deleteById(@PathVariable("serviceTypeId") Integer serviceTypeId) {
		
		Optional<ServiceTypeEntity> services = serviceRepo.findById(serviceTypeId);
		
		if ( services != null) {
			serviceRepo.deleteById(serviceTypeId);
			
			return ResponseEntity.ok(services);
		}
		
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	
	
	
	
	

	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateById(@RequestBody ServiceTypeEntity servies){
		
		ServiceTypeEntity  oldService = serviceRepo.findById(servies.getServiceTypeId()).get();
		
		if ( oldService != null ) {
			
			oldService.setServiceTypeName(servies.getServiceTypeName());
			
			serviceRepo.save(oldService);
			
			return ResponseEntity.ok(oldService);
		}
		
		serviceRepo.save(oldService);
		
		return ResponseEntity.ok(oldService);
		
	}
}
