package com.shopeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopeasy.entity.Category;
import com.shopeasy.service.CategoryService;

@Controller
@RequestMapping("/shopeasy")
public class CategoryController {

	@Autowired
	CategoryService service;
	
	@PostMapping("/save-category")
	public ResponseEntity<Boolean> saveCategory(@RequestBody Category category){
		boolean isSaved = service.saveCategory(category);
		return new ResponseEntity<>(isSaved, HttpStatus.CREATED);
	}
}
