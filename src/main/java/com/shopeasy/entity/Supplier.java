package com.shopeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {

	@Id
	private int supplierId;
	@Column(unique=false,nullable=false)
	private String supplierName;
	@Column(unique=false,nullable=false)
	private String supplierCity;
	@Column(unique=false,nullable=false)
	private String supplierPostalCode;
	@Column(unique=false,nullable=false)
	private String supplierCountry;
	@Column(unique=true,nullable=false)
	private String supplierMobile;
	
	public Supplier() {}
	
	public Supplier(int supplierId, String supplierName, String supplierCity, String supplierPostalCode,
			String supplierCountry, String supplierMobile) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierCity = supplierCity;
		this.supplierPostalCode = supplierPostalCode;
		this.supplierCountry = supplierCountry;
		this.supplierMobile = supplierMobile;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierCity() {
		return supplierCity;
	}

	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}

	public String getSupplierPostalCode() {
		return supplierPostalCode;
	}

	public void setSupplierPostalCode(String supplierPostalCode) {
		this.supplierPostalCode = supplierPostalCode;
	}

	public String getSupplierCountry() {
		return supplierCountry;
	}

	public void setSupplierCountry(String supplierCountry) {
		this.supplierCountry = supplierCountry;
	}

	public String getSupplierMobile() {
		return supplierMobile;
	}

	public void setSupplierMobile(String supplierMobile) {
		this.supplierMobile = supplierMobile;
	}
	
	
}
