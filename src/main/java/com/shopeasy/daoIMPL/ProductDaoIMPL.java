package com.shopeasy.daoIMPL;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopeasy.dao.ProductDao;
import com.shopeasy.entity.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public boolean saveProduct(Product product) {
		Session session= null;
		boolean isSaved = false;
		try {
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Product.class);
				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();
				isSaved = true;
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return isSaved;
	}

	@Override
	public boolean saveMultipleProduct(List<Product> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		Session session = null;
		boolean isUpdated = false;
		try {
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Product.class);
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
	public Product getSingleProductById(String productId) {
		Session session= null;
		
		List<Product> list = null;
		try {
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Product.class);
				list = criteria.list();
				for (Product product : list) {
					if(product.productId.equals(productId))
						return product;
				}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		Session session= null;
		List<Product> list = null;
		try {
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Product.class);
				list = criteria.list();
				return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return null;
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
