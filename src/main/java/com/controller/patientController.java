package com.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
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

import com.entity.LoginRequest;
import com.entity.PaymentEntity;
import com.entity.patientEntity;
import com.repository.PaymentRepository;
import com.repository.patientRepository;

@RestController
@RequestMapping("/patient")
public class patientController {

	@Autowired
	patientRepository patientRepo;

	@Autowired
	PaymentRepository paymentRepo;

	@PostMapping("/save")
	public ResponseEntity<?> addPatient(@RequestBody patientEntity patient) {

		patientRepo.save(patient);

		return ResponseEntity.ok(patient);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllPatients() {
		List<patientEntity> patients = patientRepo.findAll();

		return ResponseEntity.ok(patients);
	}

	@GetMapping("/get/{patientId}")
	public ResponseEntity<?> getPatientByID(@PathVariable("patientId") Integer patientId) {

		if (patientRepo.findById(patientId).isPresent()) {
			patientEntity patient = patientRepo.findById(patientId).get();
			return ResponseEntity.ok(patient);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// Delete

//	
//	

	@DeleteMapping("/delete/{patientId}")
	public ResponseEntity<?> deletePatinetById(@PathVariable("patientId") Integer patientId) {
		Optional<patientEntity> patient = patientRepo.findById(patientId);

		if (patient.isPresent()) {
			patientRepo.deleteById(patientId);
			return ResponseEntity.ok(patient);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// Update

	@PutMapping("/update")
	public ResponseEntity<?> updatePatient(@RequestBody patientEntity patient) {

		patientEntity oldPatient = patientRepo.findById(patient.getPatientId()).get();

		try {

			oldPatient.setAddress(patient.getAddress());
			oldPatient.setAlternatievNo(patient.getAlternatievNo());
			oldPatient.setBloodGroup(patient.getBloodGroup());
			oldPatient.setCity(patient.getCity());
			oldPatient.setCountry(patient.getCountry());
			oldPatient.setDiseases(patient.getDiseases());
			oldPatient.setEmail(patient.getEmail());
			oldPatient.setEyeCard(patient.getEyeCard());
			oldPatient.setFirstName(patient.getFirstName());
			oldPatient.setGender(patient.getGender());
			oldPatient.setLastName(patient.getLastName());
			oldPatient.setMaritalStatus(patient.getMaritalStatus());
			oldPatient.setMiddleName(patient.getMiddleName());
			oldPatient.setMRDNO(patient.getMRDNO());
			oldPatient.setOccupation(patient.getOccupation());
			oldPatient.setPassword(patient.getPassword());
			oldPatient.setPincode(patient.getPincode());
			oldPatient.setRateList(patient.getRateList());
			oldPatient.setReferredBy(patient.getReferredBy());
			oldPatient.setRegistrationType(patient.getState());

			patientRepo.save(oldPatient);

			return ResponseEntity.ok(oldPatient);

		} catch (Exception e) {
			System.out.println(e);
		}
		return ResponseEntity.ok(oldPatient);

	}

	// Payment For patient find by patientId In payment

	@PostMapping("/payment/{patientId}")
	public ResponseEntity<?> getAllPaymentOfPatient(@PathVariable("patientId") Integer patientId) {

		List<PaymentEntity> allPayments = paymentRepo.findAll(); // Assuming paymentRepo is your repository for payments

		// Filter payments for the specified patientId
		List<PaymentEntity> patientPayments = allPayments.stream()
				.filter(payment -> payment.getPatient().getPatientId() == patientId).collect(Collectors.toList());

		return ResponseEntity.ok(patientPayments);

	}

	// for login

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		patientEntity patient = patientRepo.findByEmail(email);

		if (patient != null && patient.getPassword().equals(password)) {
			return ResponseEntity.ok(patient);
		} else {
			return ResponseEntity.status(401).body("Invalid email or password");
		}
	}

}
