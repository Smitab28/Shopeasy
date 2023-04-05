package com.shopeasy.serviceIMPL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopeasy.dao.ProductDao;
import com.shopeasy.entity.Product;
import com.shopeasy.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {
	
	@Autowired
	ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {
		String productId = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		product.setProductId(productId);
		boolean isSaved = dao.saveProduct(product);
		return isSaved;
	}

	@Override
	public boolean saveMultipleProduct(List<Product> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getSingleProductById(String productId) {
		Product product = dao.getSingleProductById(productId);
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = dao.getAllProduct();
		return list;
	}

	@Override
	public boolean deleteProduct() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCountOfTotalProduct() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double sumOfProductPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> sortProductById_ASC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> sortProductById_DESC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getMaxPriceProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getMinPriceProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
