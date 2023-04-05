package com.shopeasy.dao;

import java.util.List;

import com.shopeasy.entity.Product;

public interface ProductDao {

	public boolean saveProduct(Product product);
	public boolean saveMultipleProduct(List<Product> list);
	public boolean updateProduct(Product product);
	public Product getSingleProductById(String productId);
	public List<Product> getAllProduct();
	public boolean deleteProduct();
	public int getCountOfTotalProduct();
	public double sumOfProductPrice();
	public List<Product> sortProductById_ASC();
	public List<Product> sortProductById_DESC();
	public Product getMaxPriceProduct();
	public Product getMinPriceProduct();
	
	
}
