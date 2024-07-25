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

import com.entity.AppointmentStatusEntity;
import com.repository.AppointmentStatusRepository;

@RestController
@RequestMapping("/appointmentstatus")
public class AppointmentStatusController {

	@Autowired
	AppointmentStatusRepository appointmentStatusRepo;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody AppointmentStatusEntity appointmentStatus) {

		appointmentStatusRepo.save(appointmentStatus);

		return ResponseEntity.ok(appointmentStatus);

	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {

		List<AppointmentStatusEntity> appointmaAppointmentStatus = appointmentStatusRepo.findAll();

		return ResponseEntity.ok(appointmaAppointmentStatus);
	}

	@GetMapping("/get/{appointmentStatusId}")
	public ResponseEntity<?> getById(@PathVariable("appointmentStatusId") Integer appointmentStatusId) {

		Optional<AppointmentStatusEntity> appointmentStatus = appointmentStatusRepo.findById(appointmentStatusId);

		if (appointmentStatus != null) {

			return ResponseEntity.ok(appointmentStatus);
		}

		else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/delete{appointmentStatusId}")
	public ResponseEntity<?> deleteById(@PathVariable("appointmentStatusId") Integer appointmentStatusId) {

		Optional<AppointmentStatusEntity> appointmentStatus = appointmentStatusRepo.findById(appointmentStatusId);

		if (appointmentStatus != null) {

			appointmentStatusRepo.deleteById(appointmentStatusId);
			return ResponseEntity.ok(appointmentStatus);
		}

		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatItem(@RequestBody AppointmentStatusEntity appointmentStatus) {
		
		AppointmentStatusEntity oldStatus = appointmentStatusRepo.findById(appointmentStatus.getAppointmentStatusId()).get();
		
		if (oldStatus != null) {
			oldStatus.setStatusName(appointmentStatus.getStatusName());
			
			appointmentStatusRepo.save(oldStatus);

			return ResponseEntity.ok(oldStatus);

		}
		
		appointmentStatusRepo.save(oldStatus);

		return ResponseEntity.ok(oldStatus);

	}
}
