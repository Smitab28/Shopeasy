package com.shopeasy.daoIMPL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopeasy.dao.SupplierDao;
import com.shopeasy.entity.Supplier;

@Repository
public class SupplierDaoIMPL implements SupplierDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public boolean saveSupplier(Supplier supplier) {
		Session session =null;
		boolean isSaved = false;
		try {
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Supplier.class);
				Transaction transaction =session.beginTransaction();
				session.save(supplier);
				transaction.commit();
				isSaved = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
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
