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

import com.entity.MaterialEntity;
import com.repository.MaterialRepository;

@RestController
@RequestMapping("/material")
public class MaterialController {
	
	@Autowired
	MaterialRepository materialRepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody MaterialEntity material) {
		
		materialRepo.save(material);
		
		return ResponseEntity.ok(material);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllRecord(){
		List<MaterialEntity> material = materialRepo.findAll();
		
		return ResponseEntity.ok(material);
	}
	
	@GetMapping("material/{materialId}") 
	public ResponseEntity<?> getMaterialById(@PathVariable("materialId") Integer materialId) {
		
		if (materialRepo.findById(materialId).isPresent()) {
			Optional<MaterialEntity> material = materialRepo.findById(materialId);
			return ResponseEntity.ok(material);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("delete/{materialId}") 
	public ResponseEntity<?> deleteById(@PathVariable("materialId") Integer materialId) {
		
		Optional<MaterialEntity> material = materialRepo.findById(materialId);
		
		if (material != null) {
			materialRepo.deleteById(materialId);
			return ResponseEntity.ok(material);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateMatrial(@RequestBody MaterialEntity material) {
		
		MaterialEntity oldMaterial = materialRepo.findById(material.getMaterialId()).get();
		
		
		if (oldMaterial != null) {
			oldMaterial.setMaterialName(material.getMaterialName());
			oldMaterial.setDescription(material.getDescription());
			
			materialRepo.save(oldMaterial);
			
			return ResponseEntity.ok(oldMaterial);
		}
		
		materialRepo.save(oldMaterial);
		
		return ResponseEntity.ok(oldMaterial);
	}
	
}
