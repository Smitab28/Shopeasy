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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSupplier(int supplierId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Supplier getSupplierById(int supplierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

}
