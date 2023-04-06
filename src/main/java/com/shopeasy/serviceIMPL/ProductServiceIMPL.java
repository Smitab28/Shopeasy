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
		return dao.saveMultipleProduct(list);
	}

	@Override
	public boolean updateProduct(Product product) {
		return dao.updateProduct(product);
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
	public boolean deleteProduct(String productId) {
		return dao.deleteProduct(productId);
	}

	@Override
	public int getCountOfTotalProduct() {
		return dao.getCountOfTotalProduct();
	}

	@Override
	public double sumOfProductPrice() {
		return dao.sumOfProductPrice();
	}

	@Override
	public List<Product> sortProductById_ASC() {
		return dao.sortProductById_ASC();
	}

	@Override
	public List<Product> sortProductByName_DESC() {
		return dao.sortProductByName_DESC();
	}

	@Override
	public Product getMaxPriceProduct() {
		return dao.getMaxPriceProduct();
	}

	@Override
	public Product getMinPriceProduct() {
		return dao.getMinPriceProduct();
	}

	
}
