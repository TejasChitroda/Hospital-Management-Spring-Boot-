package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.PackageEntity;
import com.repository.PackageRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/package")
public class PackageController {
	
	@Autowired
	PackageRepository packageRepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody PackageEntity packageE) {
		
		packageRepo.save(packageE);
		
		return ResponseEntity.ok(packageE);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllPackage() {
		List<PackageEntity> pack = packageRepo.findAll();
		return  ResponseEntity.ok(pack);
	}
	
	@GetMapping("/get/{packageId}")
    public ResponseEntity<?> getById(@PathVariable("packageId") Integer packageId) {
        Optional<PackageEntity> packageOpt = packageRepo.findById(packageId);
        
        if (packageOpt.isPresent()) {
            PackageEntity packageE = packageOpt.get();
            return ResponseEntity.ok(packageE);
        } else {
            return ResponseEntity.noContent().build();
        }
	}
	
	@DeleteMapping("/delete/{packageId}")
    public ResponseEntity<?> deletePackageById(@PathVariable("packageId") Integer packageId) {
        Optional<PackageEntity> packageOpt = packageRepo.findById(packageId);
        
        if (packageOpt.isPresent()) {
            packageRepo.deleteById(packageId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updatePackage(@RequestBody PackageEntity packageE) {
        Integer packageId = packageE.getPackageID();
        Optional<PackageEntity> packageOpt = packageRepo.findById(packageId);
        
        if (packageOpt.isPresent()) {
            PackageEntity oldPackage = packageOpt.get();
            // Update all relevant fields based on the values provided in the request body
            oldPackage.setName(packageE.getName());
//            oldPackage.setDescription(packageE.getDescription());
            // Update other fields as needed
            
            packageRepo.save(oldPackage);
            return ResponseEntity.ok(oldPackage);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
