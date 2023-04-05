package com.shopeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopeasy.entity.Supplier;
import com.shopeasy.service.SupplierService;

@Controller
@RequestMapping("/shopeasy")
public class SupplierController {
	
	@Autowired
	private SupplierService service;
	
	@PostMapping("/save-supplier")
	public ResponseEntity<Boolean> saveSupplier(@RequestBody Supplier supplier) {
		boolean isSaved = service.saveSupplier(supplier);
		return new ResponseEntity<>(isSaved, HttpStatus.CREATED);
	}

}
