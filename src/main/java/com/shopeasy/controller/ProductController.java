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
import org.springframework.web.bind.annotation.RequestParam;

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
		if(list.isEmpty())
		return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		else
				return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	@GetMapping(value = "/get-maxpriceproduct")
	public ResponseEntity<Product> getMaxPriceProduct(){
		Product product = service.getMaxPriceProduct();
		if(product!=null)
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		else
			return new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/delete-product")
	public ResponseEntity<Boolean> deleteProduct(@RequestParam String productId){
		boolean isDeleted= service.deleteProduct(productId);
		if(isDeleted)
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/update-product")
	public ResponseEntity<Boolean> updateProduct(Product product){
		boolean isUpdated = service.updateProduct(product);
		if(isUpdated)
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/get-minpriceproduct")
	public ResponseEntity<Product> getMinPriceProduct(){
		Product product = service.getMinPriceProduct();
		if(product!=null)
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		else
			return new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/sortproductbyname-desc")
	public ResponseEntity<List<Product>> sortProductByName_DESC(){
		List<Product> list = service.sortProductByName_DESC();
		if(list.isEmpty())
		return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		else
				return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/sortproductbyid-asc")
	public ResponseEntity<List<Product>> sortProductById_ASC(){
		List<Product> list = service.sortProductById_ASC();
		if(list.isEmpty())
		return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		else
				return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
}
