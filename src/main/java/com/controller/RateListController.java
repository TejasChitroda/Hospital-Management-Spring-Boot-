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

import com.entity.RateListEntity;
import com.repository.RateListRepository;

@RestController
@RequestMapping("/ratelist")
public class RateListController {

	@Autowired
	RateListRepository rateListRepo;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody RateListEntity rateListType) {

		rateListRepo.save(rateListType);

		return ResponseEntity.ok(rateListType);
	}

// get all records
	@GetMapping("/all")
	public ResponseEntity<?> getAllRecord() {
		List<RateListEntity> rate = rateListRepo.findAll();

		return ResponseEntity.ok(rate);
	}

// get record by id

	@GetMapping("/get/{rateListTypeId}")
	public ResponseEntity<?> getRateById(@PathVariable("rateListTypeId") Integer rateListTypeId) {

		if (rateListRepo.findById(rateListTypeId).isPresent()) {
			Optional<RateListEntity> rate = rateListRepo.findById(rateListTypeId);
			return ResponseEntity.ok(rate);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/delete/{rateListTypeId}")
	public ResponseEntity<?> deleterateListType(@PathVariable("rateListTypeId") Integer rateListTypeId) {

		Optional<RateListEntity> rate = rateListRepo.findById(rateListTypeId);

		if (rate != null) {
			rateListRepo.deleteById(rateListTypeId);
			return ResponseEntity.ok(rate);
		}

		else {
			return ResponseEntity.noContent().build();
		}
	}

//	@PutMapping("/update")
//	public ResponseEntity<?> updateRate(@RequestBody RateListEntity rateListType) {
//
//		RateListEntity oldRate = rateListRepo.findById(rateListType.getRateListId()).get();
//
//		if (oldRate != null) {
//			oldRate.setRateList(rateListType.getRateType());
//
//			rateListRepo.save(oldRate);
//
//			return ResponseEntity.ok(oldRate);
//		}
//		rateListRepo.save(oldRate);
//
//		return ResponseEntity.ok(oldRate);
//	}

}
