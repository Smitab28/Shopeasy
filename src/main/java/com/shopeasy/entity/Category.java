package com.shopeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	public int categoryId;
	@Column(unique=false,nullable=false)
	public String categoryName;
	@Column(unique=false,nullable=true)
	public String categoryDiscription;
	@Column(unique=false,nullable=false)
	public int discount;
	@Column(unique=false,nullable=false)
	public int gst;
	@Column(unique=false,nullable=false)
	public double deliveryCharges;
	
	public Category() {}
	
	public Category(int categoryId, String categoryName, String categoryDiscription, int discount, int gst,
			double deliveryCharges) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDiscription = categoryDiscription;
		this.discount = discount;
		this.gst = gst;
		this.deliveryCharges = deliveryCharges;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDiscription() {
		return categoryDiscription;
	}
	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getGst() {
		return gst;
	}
	public void setGst(int gst) {
		this.gst = gst;
	}
	public double getDeliveryCharges() {
		return deliveryCharges;
	}
	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDiscription="
				+ categoryDiscription + ", discount=" + discount + ", gst=" + gst + ", deliveryCharges="
				+ deliveryCharges + "]";
	}
		
}
