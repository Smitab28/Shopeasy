package com.shopeasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopeasy.entity.Category;
import com.shopeasy.entity.Product;
import com.shopeasy.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService service;
	
	@PostMapping("/save-category")
	public ResponseEntity<Boolean> saveCategory(@RequestBody Category category){
		boolean isSaved = service.saveCategory(category);
		if(isSaved)
			return new ResponseEntity<>(isSaved, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(isSaved, HttpStatus.ALREADY_REPORTED);
	}
	
	@PutMapping("/update-category")
	public ResponseEntity<Boolean> updateCategory(@RequestBody Category category){
		boolean isUpdated = service.updateCategory(category);
		if(isUpdated)
			return new ResponseEntity<>(isUpdated, HttpStatus.OK);
		else
			return new ResponseEntity<>(isUpdated, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/delete-category/{categoryId}")
	public ResponseEntity<Boolean> deleteCategory(@PathVariable int categoryId){
		boolean isDeleted = service.deleteCategory(categoryId);
		if(isDeleted) {
			return new ResponseEntity<>(isDeleted, HttpStatus.OK);
		}
		return new ResponseEntity<>(isDeleted, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/get-singlecategory/{categorytId}")
	public ResponseEntity<Category> getSingleProductById(@PathVariable int categoryId){
		Category category = service.getCategorybyId(categoryId);
		if(category!=null) {
			return new ResponseEntity<>(category, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(category, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/get-all-catgory")
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> list = service.getAllCategory();
		if(list.isEmpty())
			return new ResponseEntity<List<Category>>( HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Category>>(list , HttpStatus.OK);
	}
}
