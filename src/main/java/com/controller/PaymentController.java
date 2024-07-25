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

import com.entity.PaymentEntity;
import com.entity.patientEntity;
import com.repository.PaymentRepository;

@RestController
@RequestMapping("/paymenet")
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepo;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody PaymentEntity payment) {
		paymentRepo.save(payment);

		return ResponseEntity.ok(payment);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {

		List<PaymentEntity> payment = paymentRepo.findAll();

		return ResponseEntity.ok(payment);

	}

	@GetMapping("/get/{paymentId}")
	public ResponseEntity<?> getById(@PathVariable("paymentId") Integer paymentId) {

		Optional<PaymentEntity> payment = paymentRepo.findById(paymentId);

		if (payment != null) {
			return ResponseEntity.ok(payment);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/delete/{paymentId}")
	public ResponseEntity<?> deleteById(@PathVariable("paymentId") Integer paymentId) {

		Optional<PaymentEntity> payment = paymentRepo.findById(paymentId);

		if (payment != null) {
			paymentRepo.deleteById(paymentId);
			return ResponseEntity.ok(payment);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PutMapping("/update") 
	public ResponseEntity<?> updateRecord(@RequestBody PaymentEntity payment){
		
		PaymentEntity oldPayment = paymentRepo.findById(payment.getPaymentId()).get();
		
		if (oldPayment != null) {
			oldPayment.setAmount(payment.getAmount());
			oldPayment.setDate(payment.getDate());
			oldPayment.setDiscount(payment.getDiscount());
			oldPayment.setPatient(payment.getPatient());
			oldPayment.setRemarks(payment.getRemarks());
			oldPayment.setTranscationRef(payment.getTranscationRef());
			
			
			paymentRepo.save(oldPayment);

			return ResponseEntity.ok(oldPayment);
		}
		
		paymentRepo.save(oldPayment);

		return ResponseEntity.ok(oldPayment);
	}
}
