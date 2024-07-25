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
import com.entity.DoctorDocumentEntity;
import com.repository.DoctorDocumentRepository;

@RestController
@RequestMapping("/doctordocument")
public class DoctorDocumentController {

	@Autowired
	DoctorDocumentRepository doctorDocumentRepo;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody DoctorDocumentEntity doctorDocument) {

		doctorDocumentRepo.save(doctorDocument);

		return ResponseEntity.ok(doctorDocument);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllRecord() {

		List<DoctorDocumentEntity> doctorDetails = doctorDocumentRepo.findAll();

		return ResponseEntity.ok(doctorDetails);

	}

	@GetMapping("/get/{doctorDocumentId}")
	public ResponseEntity<?> getById(@PathVariable("doctorDocumentId") Integer doctorDocumentId) {

		Optional<DoctorDocumentEntity> doctorDetails = doctorDocumentRepo.findById(doctorDocumentId);

		if (doctorDetails != null) {
			return ResponseEntity.ok(doctorDetails);
		} else {
			return ResponseEntity.noContent().build();
		}

	}

	@DeleteMapping("/delete/{doctorDocumentId}")
	public ResponseEntity<?> deletebyID(@PathVariable("doctorDocumentId") Integer doctorDocumentId) {

		Optional<DoctorDocumentEntity> doctorDetails = doctorDocumentRepo.findById(doctorDocumentId);

		if (doctorDetails != null) {
			doctorDocumentRepo.deleteById(doctorDocumentId);

			return ResponseEntity.ok(doctorDetails);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateDoctorDocument(@RequestBody DoctorDocumentEntity doctorDocument) {
		
		DoctorDocumentEntity oldDoctorDocument = doctorDocumentRepo.findById(doctorDocument.getDoctorDocumentId()).get();
		
		if(oldDoctorDocument != null ) {
			
			oldDoctorDocument.setDoctorDocumentName(doctorDocument.getDoctorDocumentName());
			oldDoctorDocument.setDoctorDocumentPath(doctorDocument.getDoctorDocumentPath());
			oldDoctorDocument.setDoctor(doctorDocument.getDoctor());
			
			doctorDocumentRepo.save(oldDoctorDocument);
			
			return ResponseEntity.ok(doctorDocument);
		}
		
		doctorDocumentRepo.save(oldDoctorDocument);
		
		return ResponseEntity.ok(doctorDocument);
		
		
		
	}

}
