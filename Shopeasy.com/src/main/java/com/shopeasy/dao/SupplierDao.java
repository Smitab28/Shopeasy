package com.shopeasy.dao;

import java.util.List;

import com.shopeasy.entity.Supplier;

	public interface SupplierDao {
	public boolean saveSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(int supplierId);
	public Supplier getSupplierById(int supplierId);
	public List<Supplier> getAllSupplier();
}
