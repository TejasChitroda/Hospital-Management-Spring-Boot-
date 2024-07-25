package com.controller;

import java.awt.Paint;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AppointmentEntity;
import com.entity.DoctorDetailsEntity;
import com.entity.LoginRequest;
import com.entity.patientEntity;
import com.repository.AppointmentRepository;
import com.repository.DoctorDetailsRepository;
import com.repository.patientRepository;

@RestController
@RequestMapping("/doctordashboard")
public class DoctorDashBoardController {
	
	@Autowired
	DoctorDetailsRepository doctorDetails;
	
	@Autowired
	patientRepository patientRepo;
	
	@Autowired
	AppointmentRepository appointmentRepo;
	
	
	// for login

		@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody DoctorDetailsEntity doctor) {

			String email = doctor.getEmail();
			String password = doctor.getPassword();

			DoctorDetailsEntity patient = doctorDetails.findByEmail(email);

			if (patient != null && patient.getPassword().equals(password)) {
				return ResponseEntity.ok(patient);
			} else {
				return ResponseEntity.status(401).body("Invalid email or password");
			}
		}
		
		
	// get all appointment
		
		@GetMapping("/all/appointment")
		public ResponseEntity<?> getAllAppointment() {
			
			List<patientEntity> patient = patientRepo.findAll();
			
			return ResponseEntity.ok(patient);
		}
		
		
		
		// Todays appointment
		@GetMapping("/todaysappointment")
		public ResponseEntity<?> todaysAppointment() {

			LocalDate today = LocalDate.now();

			List<AppointmentEntity> appointments = appointmentRepo.findAll();

			List<AppointmentEntity> todaysAppointments = appointments.stream().filter(appointment -> {
				LocalDate appointmentDate = LocalDate.parse(appointment.getAppointmentDate(),
						DateTimeFormatter.ofPattern("dd-MM-yy"));
				return appointmentDate.equals(today);
			}).collect(Collectors.toList());

			return ResponseEntity.ok(todaysAppointments);

		}

		// Previous appointment list
		@GetMapping("/previousappointment")
		public ResponseEntity<?> previousAppointment() {

			LocalDate today = LocalDate.now();

			List<AppointmentEntity> appointments = appointmentRepo.findAll();

			List<AppointmentEntity> previousAppointments = appointments.stream().filter(appointment -> {
				LocalDate appointmentDate = LocalDate.parse(appointment.getAppointmentDate(),
						DateTimeFormatter.ofPattern("dd-MM-yy"));
				return appointmentDate.isBefore(today);
			}).collect(Collectors.toList());

			return ResponseEntity.ok(previousAppointments);
		}

		
		
		
		// For Upcomming Appointment

		@GetMapping("/upcommingappointment")
		public ResponseEntity<?> upCommingAppointment() {

			LocalDate today = LocalDate.now();

			List<AppointmentEntity> appointments = appointmentRepo.findAll();

			List<AppointmentEntity> upcomingAppointments = appointments.stream().filter(appointment -> {
				LocalDate appointmentDate = LocalDate.parse(appointment.getAppointmentDate(),
						DateTimeFormatter.ofPattern("dd-MM-yy"));
				return appointmentDate.isAfter(today);
			}).collect(Collectors.toList());

			return ResponseEntity.ok(upcomingAppointments);
		}
		
		
		
		// get all patient details
		// access to modify doctor details and doctor document details
		
		
		
	
}
