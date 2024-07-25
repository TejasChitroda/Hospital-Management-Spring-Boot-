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

import com.entity.PackageItemEntity;
import com.repository.PackageItemRepository;

@RestController
@RequestMapping("/packageitem")
public class PackageItemController {
	
	@Autowired
	PackageItemRepository packageitemrepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody PackageItemEntity packageItem){
		
		packageitemrepo.save(packageItem);
		
		return ResponseEntity.ok(packageItem);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<PackageItemEntity> packageItem = packageitemrepo.findAll();
		
		return ResponseEntity.ok(packageItem);
	}
	
	@GetMapping("/get/{packageItemId}")
	public ResponseEntity<?> getById(@PathVariable("packageItemId") Integer packageItemId) {
		
		if(packageitemrepo.findById(packageItemId).isPresent()) {
			
			Optional<PackageItemEntity> packageItem = packageitemrepo.findById(packageItemId);
			
			return ResponseEntity.ok(packageItem);
		}
		else {
			
			return ResponseEntity.noContent().build();
		}
		
	}
	
	
	// something went Wrong Here
	
	@DeleteMapping("/delete/{packageItemId}")
	public ResponseEntity<?> deleteById(@PathVariable("PackageItemId") Integer packageItemId) {
		
		Optional<PackageItemEntity> packageItem = packageitemrepo.findById(packageItemId);
		
		if (packageItem != null) {
			packageitemrepo.deleteById(packageItemId);
			
			return ResponseEntity.ok(packageItem);
		}
		
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePackageItem(@RequestBody PackageItemEntity packageItem) {
		
		PackageItemEntity oldItem = packageitemrepo.findById(packageItem.getPackageItemId()).get();
		
		if (oldItem != null) {
			oldItem.setItem(packageItem.getItem());
			oldItem.setPackages(packageItem.getPackages());
			
			packageitemrepo.save(oldItem);
			
			return ResponseEntity.ok(oldItem);
		}
		
		packageitemrepo.save(oldItem);
		
		return ResponseEntity.ok(oldItem);
		
		
	}
}
