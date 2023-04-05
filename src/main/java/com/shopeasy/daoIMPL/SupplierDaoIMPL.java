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
		Session session = null;
		boolean isUpdated = false;
		try {
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Supplier.class);
				Transaction transaction = session.beginTransaction();
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return isUpdated;
	}

	@Override
	public boolean deleteSupplier(int supplierId) {
		Session session = null;
		boolean isDeleted = false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();

			Supplier supplier = getSupplierById(supplierId);
			if (supplier != null) {
				session.delete(supplier);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isDeleted;
	}

	@Override
	public Supplier getSupplierById(int supplierId) {
		Supplier supplier = null;
		Session session = null;
		try {
			session = sf.openSession();

			supplier = session.get(Supplier.class, supplierId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return supplier;
	}

	@Override
	public List<Supplier> getAllSupplier() {
		Session session = null;
		List<Supplier> list = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Supplier.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

}
