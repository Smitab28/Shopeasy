package com.shopeasy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopeasy.entity.Product;

@Service
public interface ProductService {

	public boolean saveProduct(Product product);
	public boolean saveMultipleProduct(List<Product> list);
	public boolean updateProduct(Product product);
	public Product getSingleProductById(String productId);
	public List<Product> getAllProduct();
	public boolean deleteProduct(String productId);
	public int getCountOfTotalProduct();
	public double sumOfProductPrice();
	public List<Product> sortProductById_ASC();
	public List<Product> sortProductByName_DESC();
	public Product getMaxPriceProduct();
	public Product getMinPriceProduct();
	
}
