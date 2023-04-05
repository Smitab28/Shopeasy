package com.shopeasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopeasy.entity.Product;
import com.shopeasy.service.ProductService;

@Controller
@RequestMapping("/shopeasy")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/save-product")
	public ResponseEntity<Boolean> saveProduct(@RequestBody Product product){
		boolean isSaved = service.saveProduct(product);
		return new ResponseEntity<>(isSaved,HttpStatus.CREATED);
	}
	
	@GetMapping("/get-singleproduct/{productId}")
	public ResponseEntity<Product> getSingleProductById(@PathVariable String productId){
		Product product = service.getSingleProductById(productId);
		return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/get-allproduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> list = service.getAllProduct();
		return new ResponseEntity<List<Product>>(list, HttpStatus.NOT_FOUND);
	}
}
