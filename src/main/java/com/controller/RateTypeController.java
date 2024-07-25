package com.controller;

import java.util.List;
import java.util.Optional;

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

import com.entity.RateTypeEntity;
import com.repository.RateTypeRepository;

@RestController
@RequestMapping("/ratetype")
public class RateTypeController {

	@Autowired
	RateTypeRepository rateRepo;

//	add rate Type
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody RateTypeEntity rateType) {

		rateRepo.save(rateType);

		return ResponseEntity.ok(rateType);
	}

// get all records
	@GetMapping("/all")
	public ResponseEntity<?> getAllRecord() {
		List<RateTypeEntity> rate = rateRepo.findAll();

		return ResponseEntity.ok(rate);
	}

// get record by id

	@GetMapping("/get/{rateTypeId}")
	public ResponseEntity<?> getRateById(@PathVariable("rateTypeId") Integer rateTypeId) {

		if (rateRepo.findById(rateTypeId).isPresent()) {
			Optional<RateTypeEntity> rate = rateRepo.findById(rateTypeId);
			return ResponseEntity.ok(rate);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/delete/{rateTypeId}")
	public ResponseEntity<?> deleteRateType(@PathVariable("rateTypeId") Integer rateTypeId) {

		Optional<RateTypeEntity> rate = rateRepo.findById(rateTypeId);

		if (rate != null) {
			rateRepo.deleteById(rateTypeId);
			return ResponseEntity.ok(rate);
		}

		else {
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateRate(@RequestBody RateTypeEntity rateType) {

		RateTypeEntity oldRate = rateRepo.findById(rateType.getRateTypeId()).get();

		if (oldRate != null) {
			oldRate.setRateType(rateType.getRateType());

			rateRepo.save(oldRate);

			return ResponseEntity.ok(oldRate);
		}
		rateRepo.save(oldRate);

		return ResponseEntity.ok(oldRate);
	}

}
