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

import com.entity.ItemEntity;
import com.repository.ItemRepository;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepo;
	
	@PostMapping("save")
	public ResponseEntity<?> save(@RequestBody ItemEntity item){
		itemRepo.save(item);
		return ResponseEntity.ok(item);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		
		List<ItemEntity> item = itemRepo.findAll();
		return ResponseEntity.ok(item);
	}
	
	@GetMapping("/get/{itemId}")
	public ResponseEntity<?> getById(@PathVariable("itemId") Integer itemId) {
		
		if (itemRepo.findById(itemId).isPresent()) {
			Optional<ItemEntity> item = itemRepo.findById(itemId);
			return ResponseEntity.ok(item);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/delete/{itemId}")
	public ResponseEntity<?> deleteById(@PathVariable("itemId") Integer itemId)
	{
		Optional<ItemEntity> item = itemRepo.findById(itemId);
		
		if ( item != null ) {
			itemRepo.deleteById(itemId);
			
			return ResponseEntity.ok(item);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateItem(@RequestBody ItemEntity item) {
		
		ItemEntity  oldItem = itemRepo.findById(item.getItemId()).get();
		
		if (oldItem != null ) {
			oldItem.setItemName(item.getItemName());
			oldItem.setMaterialGroupName(item.getMaterialGroupName());
			oldItem.setAlternateName(item.getAlternateName());
			oldItem.setItemCode(item.getItemCode());
			oldItem.setHsnCode(item.getHsnCode());
			oldItem.setGstRate(item.getGstRate());
			oldItem.setMaterialName(item.getMaterialName());
			oldItem.setPrice(item.getPrice());
			oldItem.setShortName(item.getShortName());
			
			itemRepo.save(oldItem);
			
			return ResponseEntity.ok(oldItem);
		}
		
		itemRepo.save(oldItem);
		
		return ResponseEntity.ok(oldItem);
 	}
	
}
