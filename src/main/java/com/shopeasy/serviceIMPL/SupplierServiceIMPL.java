package com.shopeasy.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopeasy.dao.SupplierDao;
import com.shopeasy.entity.Supplier;
import com.shopeasy.service.SupplierService;

@Service
public class SupplierServiceIMPL implements SupplierService {

	@Autowired
	SupplierDao dao;
	@Override
	public boolean saveSupplier(Supplier supplier) {
		boolean isSaved = dao.saveSupplier(supplier);
		return isSaved;
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		boolean isUpdated = dao.updateSupplier(supplier);
		return isUpdated;
	}

	@Override
	public boolean deleteSupplier(int supplierId) {
		boolean isDeleted = dao.deleteSupplier(supplierId);
		return isDeleted;
	}

	@Override
	public Supplier getSupplierById(int supplierId) {
		Supplier supplier = dao.getSupplierById(supplierId);
		return supplier;
	}

	@Override
	public List<Supplier> getAllSupplier() {
		return dao.getAllSupplier();
	}

}
