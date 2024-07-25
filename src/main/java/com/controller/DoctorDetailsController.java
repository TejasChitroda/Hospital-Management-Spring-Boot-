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

import com.entity.DoctorDetailsEntity;
import com.repository.DoctorDetailsRepository;

import jakarta.validation.ReportAsSingleViolation;

@RestController
@RequestMapping("/doctoredetails")
public class DoctorDetailsController {
	
	
	@Autowired
	DoctorDetailsRepository doctorRepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody DoctorDetailsEntity doctoreDetails){
		
		doctorRepo.save(doctoreDetails);
		
		return ResponseEntity.ok(doctoreDetails);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<DoctorDetailsEntity> doctor = doctorRepo.findAll();
		
		return ResponseEntity.ok(doctor);
	}
	
	@GetMapping("/get/{doctorDetailsId}")
	public ResponseEntity<?> getById(@PathVariable("doctorDetailsId") Integer doctorDetailsId){
		
		Optional<DoctorDetailsEntity> doctorDetails = doctorRepo.findById(doctorDetailsId);
		
		if ( doctorDetails != null ) {
			return ResponseEntity.ok(doctorDetails);
		}
		else {
			 return ResponseEntity.noContent().build();
		}
		
		
	}
	
	@DeleteMapping("/delete/{doctoreDetailsId}")
	public ResponseEntity<?> deleteById(@PathVariable("doctorDetailsId") Integer doctorDetailsId) {
		
		Optional<DoctorDetailsEntity> doctorDetails = doctorRepo.findById(doctorDetailsId);

		if ( doctorDetails != null ) {
			doctorRepo.deleteById(doctorDetailsId);
			
			return ResponseEntity.ok(doctorDetails);
		}
		
		else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateDoctorDetails(@RequestBody DoctorDetailsEntity doctoreDetails) {
		
		DoctorDetailsEntity oldDoctor = doctorRepo.findById(doctoreDetails.getDoctorDetailsId()).get();
		
		if ( oldDoctor != null) {
			oldDoctor.setContactNum(doctoreDetails.getContactNum());
			oldDoctor.setDoctorTitleName(doctoreDetails.getDoctorTitleName());
			oldDoctor.setEmail(doctoreDetails.getEmail());
			oldDoctor.setFirstName(doctoreDetails.getFirstName());
			oldDoctor.setGender(doctoreDetails.getGender());
			oldDoctor.setJoiningDate(doctoreDetails.getJoiningDate());
			oldDoctor.setLastName(doctoreDetails.getLastName());
			oldDoctor.setPassword(doctoreDetails.getPassword());
			oldDoctor.setQualification(doctoreDetails.getQualification());
			oldDoctor.setServiceType(doctoreDetails.getServiceType());
			oldDoctor.setSpecialization(doctoreDetails.getSpecialization());
			oldDoctor.getServiceType();
			
			doctorRepo.save(oldDoctor);
			
			return ResponseEntity.ok(oldDoctor);
			
		}
		
		doctorRepo.save(oldDoctor);
		
		return ResponseEntity.ok(oldDoctor);
		
	}
	
	
	
	
	
}
