package com.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.server.ResponseStatusException;

import com.entity.AppointmentEntity;
import com.repository.AppointmentRepository;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	AppointmentRepository appointmentRepo;

	// Book appointment

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody AppointmentEntity appointment) {

		appointmentRepo.save(appointment);

		return ResponseEntity.ok(appointment);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {

		List<AppointmentEntity> appointment = appointmentRepo.findAll();

		return ResponseEntity.ok(appointment);

	}

	@GetMapping("/get/{appointmentId}")
	public ResponseEntity<?> getById(@PathVariable("appointmentId") Integer appointmentId) {

		Optional<AppointmentEntity> appointment = appointmentRepo.findById(appointmentId);

		if (appointment != null) {

			return ResponseEntity.ok(appointment);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/delete/{appointmentId}")
	public ResponseEntity<?> deleteById(@PathVariable("appointmentId") Integer appointmentId) {

		Optional<AppointmentEntity> appointment = appointmentRepo.findById(appointmentId);

		if (appointment != null) {
			appointmentRepo.deleteById(appointmentId);
			return ResponseEntity.ok(appointment);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateRecord(@RequestBody AppointmentEntity appointment) {

		AppointmentEntity oldAppointment = appointmentRepo.findById(appointment.getAppointmentId()).get();

		if (oldAppointment != null) {
			oldAppointment.setAppointmentDate(appointment.getAppointmentDate());
			oldAppointment.setAppointmentStatus(appointment.getAppointmentStatus());
			oldAppointment.setCreatedBy(appointment.getCreatedBy());
			oldAppointment.setCreatedDate(appointment.getCreatedDate());
			oldAppointment.setDoctor(appointment.getDoctor());
			oldAppointment.setPatient(appointment.getPatient());
			oldAppointment.setRateList(appointment.getRateList());

			appointmentRepo.save(oldAppointment);

			return ResponseEntity.ok(oldAppointment);

		}

		appointmentRepo.save(oldAppointment);

		return ResponseEntity.ok(oldAppointment);

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

}
