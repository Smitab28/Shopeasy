package com.shopeasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopeasy.entity.Supplier;
import com.shopeasy.service.SupplierService;

@Controller
@RequestMapping("/shopeasy")
public class SupplierController {
	
	@Autowired
	private SupplierService service;
	private List<Supplier> list;
	
	@PostMapping("/save-supplier")
	public ResponseEntity<Boolean> saveSupplier(@RequestBody Supplier supplier) {
		boolean isSaved = service.saveSupplier(supplier);
		return new ResponseEntity<>(isSaved, HttpStatus.CREATED);
	}
	
	@PutMapping("/update-supplier")
	public ResponseEntity<Boolean> updateSupplier(@RequestBody Supplier supplier){
		boolean isUpdated = service.updateSupplier(supplier);
		if(isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/delete-supplier-by-id")
	public ResponseEntity<Boolean> deleteSupplier(@RequestParam int supplierId){
		boolean isDeleted = service.deleteSupplier(supplierId);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/get-supplier-by-id")
	public ResponseEntity<Supplier> getSupplierById(@RequestParam int supplierId){
		Supplier supplier = service.getSupplierById(supplierId);
		if(supplier!=null) {
			return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
		}else {
			return new ResponseEntity<Supplier>(supplier, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("get-all-supplier")
	public ResponseEntity<List<Supplier>> getAllSupplier(){
		list = service.getAllSupplier();
		return new ResponseEntity<List<Supplier>>(list, HttpStatus.OK);
	}
}
