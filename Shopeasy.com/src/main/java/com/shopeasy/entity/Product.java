package com.shopeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@Column(unique=true, nullable=false)
	public String productId;
	@Column(unique=true,nullable = false)
	public String productName;
	@OneToOne
	public Supplier supplier;
	@OneToOne
	public Category category;
	@Column(unique=false,nullable = false)
	public int productQty;
	@Column(unique=false,nullable = false)
	public double productPrice;
	
	public Product() {}
	
	public Product(String productId, String productName, Supplier supplier, Category category, int productQty,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplier = supplier;
		this.category = category;
		this.productQty = productQty;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierId=" + supplier
				+ ", categoryId=" + category + ", productQty=" + productQty + ", productPrice=" + productPrice + "]";
	}
	
	
	
}
